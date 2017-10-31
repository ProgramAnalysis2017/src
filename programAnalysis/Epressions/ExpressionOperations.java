package programAnalysis.Epressions;

import programAnalysis.operatiors.Operators;

public class ExpressionOperations extends Expressions {

	private Expressions a1;
	private Expressions a2;
	private Operators op;
	private String operator;
	
	public ExpressionOperations() {
		super();
	}
	
	public ExpressionOperations(Expressions a1, Expressions a2, Operators op) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.op = op;
	}
	
	public ExpressionOperations(Expressions a1, String operator, Expressions a2) {
		super();
		this.a1 = a1;
		this.operator = operator;
		this.a2 = a2;		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a1 + " " + operator + " " + a2;
	}
	public Expressions getA1() {
		return a1;
	}
	public Expressions getA2() {
		return a2;
	}
	public Operators getOp() {
		return op;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setA1(Expressions a1) {
		this.a1 = a1;
	}

	public void setA2(Expressions a2) {
		this.a2 = a2;
	}

	public void setOp(Operators op) {
		this.op = op;
	}
	
}
