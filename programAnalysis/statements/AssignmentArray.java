package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class AssignmentArray extends Statements{

	private String arrayName;
	private Expressions index;
	private Expressions a;
	
	public AssignmentArray() {
		super();
	}
	
	public AssignmentArray(String arrayName, Expressions index, Expressions a) {
		super();
		this.arrayName = arrayName;
		this.index = index;
		this.a = a;
	}
	
	public String getArrayName() {
		return arrayName;
	}
	public Expressions getIndex() {
		return index;
	}
	public Expressions getA() {
		return a;
	}

	public void setArrayName(String arrayName) {
		this.arrayName = arrayName;
	}

	public void setIndex(Expressions index) {
		this.index = index;
	}

	public void setA(Expressions a) {
		this.a = a;
	}
	
}
