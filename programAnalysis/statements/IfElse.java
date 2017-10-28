package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class IfElse extends Statements {

	private Expressions b;
	private Statements s1;
	private Statements s2;
	
	public IfElse() {}
	
	public IfElse(Expressions b, Statements s1, Statements s2) {
		super();
		this.b = b;
		this.s1 = s1;
		this.s2 = s2;
	}

	public Expressions getB() {
		return b;
	}

	public void setB(Expressions b) {
		this.b = b;
	}

	public Statements getS1() {
		return s1;
	}

	public void setS1(Statements s1) {
		this.s1 = s1;
	}

	public Statements getS2() {
		return s2;
	}

	public void setS2(Statements s2) {
		this.s2 = s2;
	}

}
