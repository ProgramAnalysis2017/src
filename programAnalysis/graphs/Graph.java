package programAnalysis.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;
import programAnalysis.statements.Write;
import programAnalysis.statements.Assignment;
import programAnalysis.statements.Break;
import programAnalysis.statements.Continue;
import programAnalysis.statements.If;
import programAnalysis.statements.IfElse;
import programAnalysis.statements.ReadArray;
import programAnalysis.statements.ReadX;
import programAnalysis.Epressions.VariableX;
import programAnalysis.operatiors.Opa;
import programAnalysis.operatiors.Opr;
import programAnalysis.programs.Program;
import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.Declarations.IntArray;
import programAnalysis.Declarations.IntX;
import programAnalysis.Epressions.Array;
import programAnalysis.Epressions.ExpressionOperations;
import programAnalysis.Epressions.Expressions;
import programAnalysis.Epressions.False;
import programAnalysis.Epressions.IntegerN;
import programAnalysis.Epressions.NotB;
import programAnalysis.Epressions.True;

public class Graph {
	
	//private ArrayList<Integer> labels;
	private int initLabel;
	private ArrayList<Flow> flows = new ArrayList<Flow>();
	private ArrayList<Flow> flowsCopy = new ArrayList<Flow>();
	private ArrayList<Flow> flowsFIFO = new ArrayList<Flow>();
	private ArrayList<Flow> flowsCopyFIFO = new ArrayList<Flow>();
	private HashMap<Integer,Object> labels = new HashMap<Integer,Object>();//Label,statements/Declarations
	private ArrayList<Object> data = new ArrayList<Object>();
	private HashMap<Integer,ArrayList<Kill>> kill = new HashMap<Integer,ArrayList<Kill>>();
	private HashMap<Integer,ArrayList<Gen>> gen = new HashMap<Integer,ArrayList<Gen>>();
	private ArrayList<VariableX> vars = new ArrayList<VariableX>(); //recording how many variables they have
	private int entry = 0;
	private int exit = 0;
	private int conditionLabel = 0;
	private int labelSum;
	
	private Program program;
	
	private ArrayList<ArrayList<String>> RDo = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> RDexit = new ArrayList<ArrayList<String>>();
	
	private ArrayList<ArrayList<String>> RDoFIFO = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> RDexitFIFO = new ArrayList<ArrayList<String>>();
	
	//data structure for Detection of Sign
	private ArrayList<ArrayList<String>> DofS = new ArrayList<ArrayList<String>>();
	
	private ArrayList<ArrayList<String>> DofSFIFO = new ArrayList<ArrayList<String>>();
	
	private HashMap<String, HashSet<String>> ds = new HashMap<String, HashSet<String>>();
	
	/**
	 * According to the program, compute declaration and statement.
	 * @param program
	 */
	public void initData(Program program) {
		if(null != program.getDeclarations()) {
			recDeclarations(program.getDeclarations());
		}
		if(null != program.getStatements()) {
			recStatements(program.getStatements());
		}
		
		initFlows();
	}

	private void recDeclarations(Declarations declarations) {
		// TODO Auto-generated method stub
		DeclarationsSeqs dSeqs = (DeclarationsSeqs) declarations;
		//put d1 into data list
		if(dSeqs.getD1() instanceof IntX) {
			data.add((IntX)dSeqs.getD1());
			IntX intx = (IntX)dSeqs.getD1();
			insideVars(intx.getVarName());
			
		} else if(dSeqs.getD1() instanceof IntArray) {
			data.add((IntArray)dSeqs.getD1());
			IntArray intArray = (IntArray)dSeqs.getD1();
			//System.out.println("this is array name " + intArray.getArrayName());
			insideVars(intArray.getArrayName());
		}
		// recursive d2
		if(null != dSeqs.getD2() && dSeqs.getD2() instanceof DeclarationsSeqs) {
			recDeclarations((DeclarationsSeqs)dSeqs.getD2());
		}
	}
	
	private void recStatements(Statements statements) {
		// TODO Auto-generated method stub
		StatementsSeqs sSeqs = (StatementsSeqs) statements;
		//System.out.println(sSeqs.getS1());
		//((StatementsSeqs)sSeqs.getS1()).getS1()
		if(sSeqs.getS1() instanceof Assignment) {
			data.add((Assignment)sSeqs.getS1());
			Assignment tempAss = (Assignment)sSeqs.getS1();
			insideVars(tempAss.getX());
		} else if(sSeqs.getS1() instanceof While) {
			data.add((While)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof If) {
			data.add((If)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof IfElse) {
			data.add((IfElse)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof ReadX) {
			data.add((ReadX)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof Write) {
			data.add((Write)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof Continue) {
			data.add((Continue)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof Break) {
			data.add((Break)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof ReadX) {
			data.add((ReadX)sSeqs.getS1());
		} else if(sSeqs.getS1() instanceof ReadArray) {
			data.add((ReadArray)sSeqs.getS1());
		}
		
		if(null != sSeqs.getS2()) {
			recStatements(sSeqs.getS2());
		}
		
	}

	//verify if a variable exists in the vars list
	private void insideVars(String x) {
		// TODO Auto-generated method stub
		boolean notExists = true;
		for(int i=0; i<vars.size(); i++) {
			//verify if the variable exists in the vars list by the comparing the String x of VariableX
			if( x.equals(((VariableX)vars.get(i)).getX()) ) {
				notExists = false;
			}
		}
		
		if(notExists) {
			vars.add(new VariableX(x));
		}
		
	}

	public void initFlows() {
		for(int i=0; i<data.size(); i++) {
			exit ++;
			if(data.get(i) instanceof While) {
				While w = (While) data.get(i);
				conditionLabel = exit;
				labels.put(exit, w.getB() );
				//if the program not starts with while
				if(exit>1) {
					flows.add( new Flow(exit-1,exit) );
				}
				exit = handleStatements(exit+1, 0, w.getS0());
				flows.add( new Flow(exit,conditionLabel) );
			} else if(data.get(i) instanceof If) {
				//same as while
				If ifStamtment = (If) data.get(i);
				conditionLabel = exit;
				labels.put(exit, ifStamtment.getB() );
				//if the program not starts with if
				if(exit>1) {
					flows.add( new Flow(exit-1,exit) );
				}
				exit = handleStatements(exit+1, 0, ifStamtment.getS0());
				//in case that the If is the last statement
				if(i<data.size()-1) {
					flows.add( new Flow(conditionLabel,exit+1) );
				}
				conditionLabel = 0;
			} else if(data.get(i) instanceof IfElse) {
				//same as while but the flow of the else should start with the condition
				IfElse ifElse = (IfElse) data.get(i);
				conditionLabel = exit;
				labels.put(exit, ifElse.getB() );
				//if the program not starts with ifelse
				if(exit>1) {
					flows.add( new Flow(exit-1,exit) );
				}
				exit = handleStatements(exit+1, 0, ifElse.getS1());
				int endLabelS1 = exit;
				if(null != ifElse.getS2()) {
					exit = handleStatements(exit+1, conditionLabel, ifElse.getS2());
				}
				//in case that the Ifelse is the last statement
				if(i<data.size()-1) {
					flows.add( new Flow(endLabelS1,exit+1) );
				}
				
				conditionLabel = 0;
			} else {
				labels.put(exit, data.get(i));
				if(entry != 0) {
					Flow f = new Flow(entry,exit);
					flows.add(f);
				}
			}
			
			if(conditionLabel == 0) {
				entry = exit;
			} else {
				entry = conditionLabel;
			}
		}
		labelSum = exit; //recording how many labels the program has
	}

	/**
	 * @param label is the current label and the flow should be (label-1, label)
	 * @param conditionLabel is the condition label used for ifelse. The flow of else should start with the condition 
	 * @param s0 is the body
	 * @return
	 */
	private int handleStatements(int label, int conditionLabel, Statements s0) {
		if(s0 instanceof StatementsSeqs) {
			if(null != ((StatementsSeqs)s0).getS1()) {
				label = handleStatements(label,conditionLabel,((StatementsSeqs)s0).getS1());
			}
			if(null != ((StatementsSeqs)s0).getS2()) {
				label = handleStatements(label+1,0,((StatementsSeqs)s0).getS2());
			}
		} else if(s0 instanceof Assignment || 
				s0 instanceof Break || 
				s0 instanceof Continue ||
				s0 instanceof Write) {
			labels.put(label, s0);
			Flow f;
			if(conditionLabel != 0) {
				f = new Flow(conditionLabel,label);
				conditionLabel = 0;
			}else {
				f = new Flow(label-1,label);
			}
			
			flows.add(f);
			
			//for verifying if this variable exists in the vars list
			//and the variables of the expressions
			if(s0 instanceof Assignment ) {
				insideVars( ((Assignment)s0).getX() );
				handleExpression(((Assignment)s0).getA());
			}
		}
		return label;
	}

	/**
	 * handle expression recursively by the argument
	 * first: check if the variable of the expression exists in the vars list
	 * @param a
	 */
	private void handleExpression(Expressions a) {
		// TODO Auto-generated method stub
		if(a instanceof Array) {
			
			insideVars(((Array)a).getArrayName());
		} else if( a instanceof IntegerN ) {
			//nothing
		} else if(a instanceof VariableX) {
			insideVars(((VariableX)a).getX());
		} else if(a instanceof ExpressionOperations) {
			ExpressionOperations expression = (ExpressionOperations) a;
			if(null != expression.getA1()) {
				handleExpression(expression.getA1());
			} 
			if(null != expression.getA2()) {
				handleExpression(expression.getA2());
			}
		}
		
		
	}

	/**
	 * initialize kill and gen
	 */
	public void initKG() {
		for (Map.Entry<Integer, Object> entry : labels.entrySet()) {
			//System.out.println("labels type is " + entry.getValue());
			if(entry.getValue() instanceof Assignment) {
				Assignment assignment = (Assignment) entry.getValue();
				Pattern pattern = Pattern.compile("[A-Z;]*");
				Matcher matcher = pattern.matcher(assignment.getX());
				if(matcher.matches()) {
					kill.put(entry.getKey(), null);//assignment of Array does not kill anything
					//for Gen
					ArrayList<Gen> gs = new ArrayList<Gen>();
					Gen g = new Gen(assignment.getX(), entry.getKey() + "");
					gs.add(g);
					gen.put(entry.getKey(), gs);
				} else {
					auxiliaryIntiKG(entry, assignment.getX());
				}
			} else if(entry.getValue() instanceof ExpressionOperations || 
					  entry.getValue() instanceof True || 
					  entry.getValue() instanceof False || 
					  entry.getValue() instanceof NotB || 
					  entry.getValue() instanceof Write || 
					  entry.getValue() instanceof Break || 
					  entry.getValue() instanceof Continue ) {
				kill.put(entry.getKey(), null); // it is null for expression or break or continue or write
				gen.put(entry.getKey(), null);
			} else if(entry.getValue() instanceof IntX) {
				auxiliaryIntiKG(entry, ((IntX)entry.getValue()).getVarName());
			} else if(entry.getValue() instanceof IntArray) {
				auxiliaryIntiKG(entry, ((IntArray)entry.getValue()).getArrayName());
			}
		}
	}

	private void auxiliaryIntiKG(Map.Entry<Integer, Object> entry, String s) {
		//for Kill
		//for normal assignment
		ArrayList<Kill> ks = getKillList(s);
		kill.put(entry.getKey(), ks);
		//for Gen
		ArrayList<Gen> gs = new ArrayList<Gen>();
		Gen g = new Gen(s, entry.getKey() + "");
		gs.add(g);
		gen.put(entry.getKey(), gs);
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
		// TODO matrix for Reaching Definition
		if( labelSum>0 ) {
			for (int i = 1; i <= labelSum; i++) {
				ArrayList<String> RDoN = new ArrayList<String>();
				ArrayList<String> RDoNFIFO = new ArrayList<String>();
				RDo.add(RDoN);
				RDoFIFO.add(RDoNFIFO);
			}
		}
		
		for(int j=0; j<vars.size(); j++) {
			RDo.get(0).add(vars.get(j).getX() + "?");
			RDoFIFO.get(0).add(vars.get(j).getX() + "?");
		}
		
		//make a copy for the FIFO
		for (int i = 0; i < flows.size(); i++) {
			Flow f = new Flow(flows.get(i).getLabel1(), flows.get(i).getLabel2());
			flowsFIFO.add(f);
		}
		for (int i = 0; i < flowsCopyFIFO.size(); i++) {
			Flow f = new Flow(flowsCopy.get(i).getLabel1(), flowsCopy.get(i).getLabel2());
			flowsCopyFIFO.add(f);
		}
		
		System.out.println("-------------------LIFO------------------------------");
		System.out.println(flows + "  | " + RDo);
		algorithm(RDo,1);
		///*
		System.out.println("-------------------FIFO------------------------------");
		System.out.println(flowsFIFO + "  | " + RDoFIFO);
		algorithmFIFO(RDoFIFO,1);
		//*/
	}
	
	/**
	 * matrix for the Detection of Sign
	 */
	public void algorithmMatrixDS() {
		// TODO For Detection of Sign
		if( labelSum>0 ) {
			for (int i = 1; i <= labelSum; i++) {
				ArrayList<String> RDoN = new ArrayList<String>();
				ArrayList<String> RDoNFIFO = new ArrayList<String>();
				DofS.add(RDoN);
				DofSFIFO.add(RDoNFIFO);
			}
		}
		
		for(int j=0; j<vars.size(); j++) {
			DofS.get(0).add(vars.get(j).getX() + ": {-,0,+}");
			DofSFIFO.get(0).add(vars.get(j).getX() + ": {-,0,+}");
			ds.put(vars.get(j).getX(), new HashSet<String>());
		}
		
		//make a copy for the FIFO
		for (int i = 0; i < flows.size(); i++) {
			Flow f = new Flow(flows.get(i).getLabel1(), flows.get(i).getLabel2());
			flowsFIFO.add(f);
		}
		for (int i = 0; i < flowsCopyFIFO.size(); i++) {
			Flow f = new Flow(flowsCopy.get(i).getLabel1(), flowsCopy.get(i).getLabel2());
			flowsCopyFIFO.add(f);
		}
		
		System.out.println("-------------------LIFO------------------------------");
		System.out.println(flows + "  | " + DofS);
		//algorithm(DofS,2);
		///*
		System.out.println("-------------------FIFO------------------------------");
		System.out.println(flowsFIFO + "  | " + DofSFIFO);
		//algorithmFIFO(DofSFIFO,2);
		//*/
	}
	
	@SuppressWarnings("unchecked")
	private void algorithm(ArrayList<ArrayList<String>> RDo, int x) {
		// TODO The algorithm for LIFO
		while(flows.size()>0) {
			Flow f = flows.get(0);
			int l = f.getLabel1();
			int _l = f.getLabel2();
			
			// RD of the left lable of flow pair
			//RDrdl and RD rd_l are used to comupute whether  (RDo(l) \ Kill(l)) U Gen(l) included in RD.(l)
			ArrayList<String> rdL = (ArrayList<String>) RDo.get(l-1).clone();
			ArrayList<String> rd_L = (ArrayList<String>) RDo.get(_l-1).clone();
			
			boolean RDexitIncludeRDentry = true;
			
			if(x==1) {
				//reaching definition kill and gen
				rdL = killAndGen(l, rdL);
				//RDo(l') = RDo(l') U RD.(l)
				// compute whether (RDo(l) \ Kill(l)) U Gen(l) included in RD.(l)
				//if the RD of flow's right hand side label has been computed
				if(rd_L.size()>0) {
					//if RDrdl and RDrd_l contains different elements
					//RDo(l') = RDo(l') U (RDo(l) \ Kill(l)) U Gen(l)
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
			}
			
			//for Detection of Sign
			if(x==2) {
				rdL = detectionOfSign(l, rdL);
				for(String s : rdL) {
					if(!rd_L.contains(s)) {
						RDexitIncludeRDentry = false;
						break;
					}
				}
			}
			
			//LIFO
			if(!RDexitIncludeRDentry) {
				for(int i=0; i<flowsCopy.size(); i++) {
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
			
			//if the loop has been compute twice, then start once again.
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
	
	@SuppressWarnings("unchecked")
	private void algorithmFIFO(ArrayList<ArrayList<String>> RDo, int x) {
		// TODO The algorithm for FIFO
		while(flowsFIFO.size()>0) {
			Flow f = flowsFIFO.get(0);
			int l = f.getLabel1();
			int _l = f.getLabel2();
			
			// RD of the left lable of flow pair
			//RDrdl and RD rd_l are used to comupute whether  (RDo(l) \ Kill(l)) U Gen(l) included in RD.(l)
			ArrayList<String> rdL = (ArrayList<String>) RDo.get(l-1).clone();
			ArrayList<String> rd_L = (ArrayList<String>) RDo.get(_l-1).clone();
			
			//reaching definition kill and gen
			rdL = killAndGen(l, rdL);
			
			//RDo(l') = RDo(l') U RD.(l)
			// compute whether (RDo(l) \ Kill(l)) U Gen(l) included in RD.(l)
			boolean RDexitIncludeRDentry = true;
			//if the RD of flow's right hand side label has been computed
			if(rd_L.size()>0) {
				//if RDrdl and RDrd_l contains different elements
				//RDo(l') = RDo(l') U (RDo(l) \ Kill(l)) U Gen(l)
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
			
			//FIFO
			if(!RDexitIncludeRDentry) {
				for(int i=0; i<flowsCopyFIFO.size(); i++) {
					if(f.equals(flowsCopyFIFO.get(i)) && i<flowsCopyFIFO.size()-1) {
						flowsFIFO.add(flowsCopyFIFO.get(i+1));
						break;
					}else if(flowsCopyFIFO.get(i).getLabel1() > flowsCopyFIFO.get(i).getLabel2() ){
						flowsFIFO.add(new Flow(flowsCopyFIFO.get(i).getLabel2(), flowsCopyFIFO.get(i).getLabel2()+1));
					}
				}
			}
			
			if(!flowsCopyFIFO.contains(f)) {
				flowsCopyFIFO.add(f);
			}
			flowsFIFO.remove(f);
			
			//if the loop has been compute twice, then start once again.
			if(_l < l) {
				flowsFIFO.add(new Flow(_l,_l+1));
			}
			
			System.out.println(flowsFIFO + "  | " + RDo);
			
			//compute all the RD. according to all the RDo
			if(flowsFIFO.size()==0) {
				System.out.println("RD.("+RDo.size()+")  | " + killAndGen(RDo.size(), RDo.get(RDo.size()-1)));
				generateRDexitFIFO();
			}
			
		}
	}

	// for the each RDexit result
	private void generateRDexit() {
		for(int i=0; i<RDo.size(); i++) {
			RDexit.add( killAndGen(i+1, RDo.get(i)) );
		}
	}
	
	// for the each RDexit result
	private void generateRDexitFIFO() {
		for(int i=0; i<RDoFIFO.size(); i++) {
			RDexitFIFO.add( killAndGen(i+1, RDoFIFO.get(i)) );
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
	 * implementing the analysis of sign detection
	 * @param l
	 * @param rdL
	 * @return
	 */
	private ArrayList<String> detectionOfSign(int l, ArrayList<String> rdL) {
		// TODO calculate the sign of each variable
		if(labels.get(l) instanceof Assignment) {
			Assignment assignment = (Assignment)labels.get(l);
			if(null != assignment.getA()) {
				HashSet<String> signs = handleExpressionDS(assignment.getA());
			}
		}
		return rdL;
	}
	
	/**
	 * handle the expression for Detection of Sign. Calculating the signs.
	 * @param a
	 * @return
	 */
	private HashSet<String> handleExpressionDS(Expressions a) {
		// TODO handle the expression for Detection of Sign
		//this is used to store the signs of the left hand side of the expression.
		HashSet<String> leftHandSideExpression = new HashSet<String>();
		//this is used to store the signs of the right hand side of the expression.
		HashSet<String> rightHandSideExpression = new HashSet<String>();
		if(a instanceof ExpressionOperations) {
			ExpressionOperations expression = (ExpressionOperations) a;
			if(expression.getA1() instanceof VariableX) {
				VariableX v = (VariableX) expression.getA1();
				leftHandSideExpression = ds.get(v.getX());
			} else if(expression.getA1() instanceof ExpressionOperations) {
				leftHandSideExpression = handleExpressionDS(expression.getA1());
			}
			
			if(expression.getA2() instanceof VariableX) {
				VariableX v = (VariableX) expression.getA2();
				rightHandSideExpression = ds.get(v.getX());
			} else if(expression.getA2() instanceof ExpressionOperations) {
				leftHandSideExpression = handleExpressionDS(expression.getA2());
			}
		}
		return null;
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

	public int getConditionLabel() {
		return conditionLabel;
	}

	public void setConditionLabel(int conditionLabel) {
		this.conditionLabel = conditionLabel;
	}

	public ArrayList<ArrayList<String>> getRDoFIFO() {
		return RDoFIFO;
	}

	public void setRDoFIFO(ArrayList<ArrayList<String>> rDoFIFO) {
		RDoFIFO = rDoFIFO;
	}

	public ArrayList<ArrayList<String>> getRDexitFIFO() {
		return RDexitFIFO;
	}

	public void setRDexitFIFO(ArrayList<ArrayList<String>> rDexitFIFO) {
		RDexitFIFO = rDexitFIFO;
	}

	public ArrayList<Flow> getFlowsFIFO() {
		return flowsFIFO;
	}

	public void setFlowsFIFO(ArrayList<Flow> flowsFIFO) {
		this.flowsFIFO = flowsFIFO;
	}

	public ArrayList<Flow> getFlowsCopyFIFO() {
		return flowsCopyFIFO;
	}

	public void setFlowsCopyFIFO(ArrayList<Flow> flowsCopyFIFO) {
		this.flowsCopyFIFO = flowsCopyFIFO;
	}

	public ArrayList<ArrayList<String>> getDofS() {
		return DofS;
	}

	public void setDofS(ArrayList<ArrayList<String>> dofS) {
		DofS = dofS;
	}

	public ArrayList<ArrayList<String>> getDofSFIFO() {
		return DofSFIFO;
	}

	public void setDofSFIFO(ArrayList<ArrayList<String>> dofSFIFO) {
		DofSFIFO = dofSFIFO;
	}

	public HashMap<String, HashSet<String>> getDs() {
		return ds;
	}

	public void setDs(HashMap<String, HashSet<String>> ds) {
		this.ds = ds;
	}

}
