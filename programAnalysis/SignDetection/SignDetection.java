package programAnalysis.SignDetection;

import java.util.ArrayList;
import java.util.HashMap;

import programAnalysis.Epressions.VariableX;
import programAnalysis.graphs.Flow;
import programAnalysis.graphs.Graph;
import programAnalysis.programs.Program;

public class SignDetection {

	private Program program;
	private Graph g;
	
	private ArrayList<Flow> flows = new ArrayList<Flow>();
	private ArrayList<Flow> flowsCopy = new ArrayList<Flow>();
	private ArrayList<Flow> flowsFIFO = new ArrayList<Flow>();
	private ArrayList<Flow> flowsCopyFIFO = new ArrayList<Flow>();
	private HashMap<Integer,Object> labels = new HashMap<Integer,Object>();//Label,statements/Declarations
	private ArrayList<Object> data = new ArrayList<Object>();
	private ArrayList<VariableX> vars = new ArrayList<VariableX>(); //recording how many variables they have
	private int entry = 0;
	private int exit = 0;
	private int conditionLabel = 0;
	private int labelSum;

	public SignDetection(Program program) {
		super();
		this.program = program;
	}
	
	public void initData() {
		g = new Graph();
		g.initData(program);
		System.out.println("------------Test Data List--------------------");
		System.out.println(g.getData());
		System.out.println("----------------------------------------------");
		System.out.println(g.getLabels());
		System.out.println(g.getFlows());
		System.out.println();
		g.algorithmMatrixDS();
		System.out.println();
		System.out.println("-----------Detection of Sign RESULT-----------------");
		int dsResult = 0;
		for(int i=1; i<g.getDofS().size(); i++) {
			dsResult ++;
			if(g.getDofS().get(i).size() == 0) {
				String s = "";
				for(VariableX v :g.getVars()) {
					s = v.getX() + ": {null}, " + s; 
				}
				s = s.substring(0, s.length()-2);
				g.getDofS().get(i).add(s);
			}
			System.out.println("label("+ (i) +")  | "+g.getDofS().get(i));
		}
		System.out.println("label("+ (g.getDofS().size()) +")  | " + g.detectionOfSign( g.getDofS().size(), g.getDofS().get(g.getDofS().size()-1) ));
	}
	
	

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Graph getG() {
		return g;
	}

	public void setG(Graph g) {
		this.g = g;
	}

	public ArrayList<Flow> getFlows() {
		return flows;
	}

	public void setFlows(ArrayList<Flow> flows) {
		this.flows = flows;
	}

	public ArrayList<Flow> getFlowsCopy() {
		return flowsCopy;
	}

	public void setFlowsCopy(ArrayList<Flow> flowsCopy) {
		this.flowsCopy = flowsCopy;
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

	public int getConditionLabel() {
		return conditionLabel;
	}

	public void setConditionLabel(int conditionLabel) {
		this.conditionLabel = conditionLabel;
	}

	public int getLabelSum() {
		return labelSum;
	}

	public void setLabelSum(int labelSum) {
		this.labelSum = labelSum;
	}
	
	
	
}
