package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class AssignmentArray extends Statements{

	private String arrayName;
	private int index;
	private Expressions a;
	
	public AssignmentArray() {
		super();
	}
	
	public AssignmentArray(String arrayName, int index, Expressions a) {
		super();
		this.arrayName = arrayName;
		this.index = index;
		this.a = a;
	}
	
	public String getArrayName() {
		return arrayName;
	}
	public int getIndex() {
		return index;
	}
	public Expressions getA() {
		return a;
	}

	public void setArrayName(String arrayName) {
		this.arrayName = arrayName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setA(Expressions a) {
		this.a = a;
	}
	
}
