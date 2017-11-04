 package programAnalysis.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;
import programAnalysis.statements.Assignment;
import programAnalysis.statements.If;
import programAnalysis.statements.IfElse;
import programAnalysis.Epressions.VariableX;
import programAnalysis.operatiors.Opa;
import programAnalysis.operatiors.Opr;
import programAnalysis.programs.Program;
import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.Declarations.IntArray;
import programAnalysis.Declarations.IntX;
import programAnalysis.Epressions.ExpressionOperations;
import programAnalysis.Epressions.Expressions;
import programAnalysis.Epressions.IntegerN;

public class Graph {
	
	//private ArrayList<Integer> labels;
	private int initLabel;
	private ArrayList<Flow> flows = new ArrayList<Flow>();
	private ArrayList<Flow> flowsCopy = new ArrayList<Flow>();
	private HashMap<Integer,Object> labels = new HashMap<Integer,Object>();//Label,statements/Declarations
	private ArrayList<Object> data = new ArrayList<Object>();
	private HashMap<Integer,ArrayList<Kill>> kill = new HashMap<Integer,ArrayList<Kill>>();
	private HashMap<Integer,ArrayList<Gen>> gen = new HashMap<Integer,ArrayList<Gen>>();
	private ArrayList<VariableX> vars = new ArrayList<VariableX>(); //recording how many variables they have
	private int entry = 0;
	private int exit = 0;
	private int whileConditionLabel = 0;
	private int labelSum;
	
	private Program program;
	
	private ArrayList<ArrayList<String>> RDo = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> RDexit = new ArrayList<ArrayList<String>>();
	

	public static void main(String[] args) {
		Graph g = new Graph();
		g.initData(g.getProgram());
		System.out.println(g.getLabels());
		System.out.println(g.getFlows());
		
		g.initKG();
		System.out.println("--------------------KILL---------------------------------");
		for(Map.Entry<Integer, ArrayList<Kill>> entry : g.getKill().entrySet()  ) {
			System.out.println(entry.getKey() + "   | " + entry.getValue());
		}
		
		System.out.println("--------------------Gen---------------------------------");
		for(Map.Entry<Integer, ArrayList<Gen>> entry : g.getGen().entrySet()  ) {
			System.out.println(entry.getKey() + "   | " + entry.getValue());
		}
		System.out.println();
		
		g.algorithmMatrix();
		System.out.println();
		int rdo = 0;
		for(ArrayList<String> list : g.getRDo()) {
			rdo ++;
			System.out.println("RDo("+rdo+")  | "+list);
		}
		
		System.out.println();
		int rdexit = 0;
		for(ArrayList<String> list : g.getRDexit()) {
			rdexit ++;
			System.out.println("RD.("+rdexit+")  | "+list);
		}
	}
	
	public void initData(Program program) {
		VariableX v1 = new VariableX("x");
		VariableX v2 = new VariableX("y");
		Statements l1 = new Assignment(v1.getX(), new IntegerN(5));// x:= 5
		Statements l2 = new Assignment(v2.getX(), new IntegerN(1)); // y:= 1
		
		//prepare for initializing While class
		//initialize the y > 0 which is expression operator expression
		IntegerN a2 = new IntegerN(1);
		Opr opr = new Opr(); // initialize all the operator(String type): "<" ">" "<=" ">=" "==" "!="
		Expressions l3 = new ExpressionOperations(v1,a2,opr.getGreater()); // x > 1
		
		Opa opa = new Opa(); // initialize all the operator(String type): "+" "-" "*" "/"
		Statements l4 = new Assignment(v2.getX(), new ExpressionOperations(v1,v2,opa.getMulti())); // y:=x*y
		Statements l5 = new Assignment(v1.getX(), new ExpressionOperations(v2,new IntegerN(1),opa.getMin()));//x:=x-1
		
		Statements s0 = new StatementsSeqs(l4,l5);
		While w = new While(l3,s0);
		
		Statements l6 = new Assignment(v1.getX(),new IntegerN(0)); // x := 0
		
		//initialize the data structure:flows,data
		data.add(l1);
		data.add(l2);
		data.add(w);
		data.add(l6);

		vars.add(v1);
		vars.add(v2);
		
		if(null != program.getDeclarations()) {
			recDeclarations(program.getDeclarations());
		} else if(null != program.getStatements()) {
			recStatements(program.getStatements());
		}
		
		
		
		
		
		initFlows();
	}
	
	private void recDeclarations(Declarations declarations) {
		if(declarations instanceof DeclarationsSeqs) {
			DeclarationsSeqs dSeqs = (DeclarationsSeqs) declarations;
			if(dSeqs.getD1() instanceof IntArray) {
				
				
				data.add(dSeqs.getD1());
			} else if(dSeqs.getD1() instanceof IntX) {
				
				
				data.add(dSeqs.getD1());
			}
			if(null != dSeqs.getD2() && dSeqs.getD2() instanceof DeclarationsSeqs) {
				recDeclarations(dSeqs.getD2());
			}
		}
	}

	public void initFlows() {
		for(int i=0; i<data.size(); i++) {
			exit ++;
			if(data.get(i) instanceof Assignment) {
				labels.put(exit, data.get(i));
				if(entry != 0) {
					Flow f = new Flow(entry,exit);
					flows.add(f);
				}
			} else if(data.get(i) instanceof While) {
				While w = (While) data.get(i);
				ExpressionOperations condition = (ExpressionOperations) w.getB();
				whileConditionLabel = exit;
				labels.put(exit, condition);
				flows.add( new Flow(exit-1,exit) );
				exit = handleStatements(exit+1, w.getS0());
				flows.add( new Flow(exit,whileConditionLabel) );
			} else if(data.get(i) instanceof If) {
				//same as while
			} else if(data.get(i) instanceof IfElse) {
				//same as while
			}
			
			if(whileConditionLabel == 0) {
				entry = exit;
			} else {
				entry = whileConditionLabel;
			}
		}
		labelSum = exit; //recording how many labels the program has
	}

	private int handleStatements(int label, Statements s0) {
		if(s0 instanceof StatementsSeqs) {
			label = handleStatements(label,((StatementsSeqs)s0).getS1());
			label = handleStatements(label+1,((StatementsSeqs)s0).getS2());
		}else if(s0 instanceof Assignment) {
			labels.put(label, s0);
			Flow f = new Flow(label-1,label);
			flows.add(f);
		} 
		return label;
	}

	/**
	 * initialize kill and gen
	 */
	public void initKG() {
		for (Map.Entry<Integer, Object> entry : labels.entrySet()) {
			if(entry.getValue() instanceof Assignment) {
				Assignment assignment = (Assignment) entry.getValue();
				//for Kill
				ArrayList<Kill> ks = getKillList(assignment.getX());
				kill.put(entry.getKey(), ks);
				//for Gen
				ArrayList<Gen> gs = new ArrayList<Gen>();
				Gen g = new Gen(assignment.getX(), entry.getKey() + "");
				gs.add(g);
				gen.put(entry.getKey(), gs);
			} else if(entry.getValue() instanceof ExpressionOperations) {
				kill.put(entry.getKey(), null);// it is null for expression
				gen.put(entry.getKey(), null);
			}
		}
	}
	
	private ArrayList<Kill> getKillList(String x) {
		ArrayList<Kill> ks = new ArrayList<Kill>();
		ks.add(new Kill(x,"?"));
		for (Map.Entry<Integer, Object> entry : labels.entrySet()) {
			if(entry.getValue() instanceof Assignment) {
				Assignment assignment = (Assignment) entry.getValue();
				if( x.equals(assignment.getX()) ) {
					ks.add(new Kill(x,entry.getKey()+""));
				}
			}
		}
		return ks;
	}

	public void algorithmMatrix() {
		ArrayList<String> RDo1 = new ArrayList<String>();
		for(int i=0; i<vars.size(); i++) {
			RDo1.add(vars.get(i) + "?");
		}
		ArrayList<String> RDo2 = new ArrayList<String>();
		ArrayList<String> RDo3 = new ArrayList<String>();
		ArrayList<String> RDo4 = new ArrayList<String>();
		ArrayList<String> RDo5 = new ArrayList<String>();
		ArrayList<String> RDo6 = new ArrayList<String>();
		RDo.add(RDo1);
		RDo.add(RDo2);
		RDo.add(RDo3);
		RDo.add(RDo4);
		RDo.add(RDo5);
		RDo.add(RDo6);
		System.out.println(flows + "  | " + RDo);
		algorithm(RDo);
	}
	
	@SuppressWarnings("unchecked")
	private void algorithm(ArrayList<ArrayList<String>> RDo) {
		while(flows.size()>0) {
			Flow f = flows.get(0);
			int l = f.getLabel1();
			int _l = f.getLabel2();
			
			ArrayList<String> rdL = (ArrayList<String>) RDo.get(l-1).clone();
			ArrayList<String> rd_L = (ArrayList<String>) RDo.get(_l-1).clone();
			
			rdL = killAndGen(l, rdL);
			
			//RDo(l') = RDo(l') U RD.(l)
			// compute whether (RDo(l) \ Kill(l)) U Gen(l) included in RD.(l)
			boolean RDexitIncludeRDentry = true;
			if(rd_L.size()>0) {
				for(String s : rdL) {
					if(!rd_L.contains(s)) {
						RDexitIncludeRDentry = false;
						break;
					}
				}
				if(!RDexitIncludeRDentry) {
					for(String s : rd_L) {
						if(!rdL.contains(s)) {
							rdL.add(s);
						}
					}
					
					RDo.add(_l-1,rdL);
					RDo.remove(_l);
				}
				
			}else {
				RDo.add(_l-1,rdL);
				RDo.remove(_l);
			}
			
			if(!RDexitIncludeRDentry) {
				for(int i=0; i<flowsCopy.size(); i++) {
					//System.out.println(flowsCopy.get(i) + "----" + i);
					//System.out.println(f.equals(flowsCopy.get(i)) + "----" + i);
					if(f.equals(flowsCopy.get(i)) && i<flowsCopy.size()-1) {
						flows.add(1,flowsCopy.get(i+1));
						break;
					}else if(flowsCopy.get(i).getLabel1() > flowsCopy.get(i).getLabel2() ){
						flows.add(1,new Flow(flowsCopy.get(i).getLabel2(), flowsCopy.get(i).getLabel2()+1));
					}
				}
			}
			
			if(!flowsCopy.contains(f)) {
				flowsCopy.add(f);
			}
			flows.remove(f);
			
			if(_l < l) {
				flows.add(0,new Flow(_l,_l+1));
			}
			
			System.out.println(flows + "  | " + RDo);
			
			//compute all the RD. according to all the RDo
			if(flows.size()==0) {
				System.out.println("RD.("+RDo.size()+")  | " + killAndGen(RDo.size(), RDo.get(RDo.size()-1)));
				generateRDexit();
			}
			
		}
	}

	private void generateRDexit() {
		for(int i=0; i<RDo.size(); i++) {
			RDexit.add( killAndGen(i+1, RDo.get(i)) );
		}
	}

	/**
	 * implementing ( RDo(L)\Kill(L) ) U Gen(L)
	 * @param l is the label L of flow(L,L'). It is used for get the kill and gen list of label L
	 * @param rdL is the RDo(L)
	 * @return
	 */
	private ArrayList<String> killAndGen(int l, ArrayList<String> rdL) {
		//kill
		ArrayList<Kill> killL = kill.get(l);
		if(killL != null) { //if nothing to kill then do nothing
			for(int i=0; i<killL.size(); i++) {
				String s = killL.get(i).getVar()+killL.get(i).getLabel();
				for(int j=0; j<rdL.size(); j++) {
					if(s.equals(rdL.get(j))) {
						rdL.remove(j);
					}
				}
			}
		}
		
		//Gen
		ArrayList<Gen> genL = gen.get(l);
		if(genL != null) {
			for(int i=0; i<genL.size(); i++) {
				boolean temp = true;
				String s = genL.get(i).getVar() + genL.get(i).getLabel();
				for(int j=0; j<rdL.size(); j++) {
					if(s.equals(rdL.get(j))) {
						temp = false;
					}
				}
				if(temp) {
					rdL.add(s);
				}
			}
		}
		
		return rdL;
	}
	

	/**
	 * Setters and Getters
	 * @return
	 */
	public int getInitLabel() {
		return initLabel;
	}

	public void setInitLabel(int initLabel) {
		this.initLabel = initLabel;
	}

	public ArrayList<Flow> getFlows() {
		return flows;
	}

	public void setFlows(ArrayList<Flow> flows) {
		this.flows = flows;
	}

	public HashMap<Integer, Object> getLabels() {
		return labels;
	}

	public void setLabels(HashMap<Integer, Object> labels) {
		this.labels = labels;
	}

	public ArrayList<Object> getData() {
		return data;
	}

	public void setData(ArrayList<Object> data) {
		this.data = data;
	}

	public ArrayList<VariableX> getVars() {
		return vars;
	}

	public void setVars(ArrayList<VariableX> vars) {
		this.vars = vars;
	}

	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}

	public int getExit() {
		return exit;
	}

	public void setExit(int exit) {
		this.exit = exit;
	}

	public int getWhileConditionLabel() {
		return whileConditionLabel;
	}

	public void setWhileConditionLabel(int whileConditionLabel) {
		this.whileConditionLabel = whileConditionLabel;
	}

	public HashMap<Integer, ArrayList<Kill>> getKill() {
		return kill;
	}

	public void setKill(HashMap<Integer, ArrayList<Kill>> kill) {
		this.kill = kill;
	}

	public HashMap<Integer, ArrayList<Gen>> getGen() {
		return gen;
	}

	public void setGen(HashMap<Integer, ArrayList<Gen>> gen) {
		this.gen = gen;
	}

	public int getLabelSum() {
		return labelSum;
	}

	public void setLabelSum(int labelSum) {
		this.labelSum = labelSum;
	}

	public ArrayList<Flow> getFlowsCopy() {
		return flowsCopy;
	}

	public void setFlowsCopy(ArrayList<Flow> flowsCopy) {
		this.flowsCopy = flowsCopy;
	}

	public ArrayList<ArrayList<String>> getRDo() {
		return RDo;
	}

	public void setRDo(ArrayList<ArrayList<String>> rDo) {
		RDo = rDo;
	}

	public ArrayList<ArrayList<String>> getRDexit() {
		return RDexit;
	}

	public void setRDexit(ArrayList<ArrayList<String>> rDexit) {
		RDexit = rDexit;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	} 
	
}
