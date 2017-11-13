package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class IfElse extends Statements {

	private Expressions b;
	private StatementsSeqs s1;
	private StatementsSeqs s2;
	
	public IfElse() {}
	
	public IfElse(Expressions b, StatementsSeqs s1, StatementsSeqs s2) {
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

	public StatementsSeqs getS1() {
		return s1;
	}

	public void setS1(StatementsSeqs s1) {
		this.s1 = s1;
	}

	public StatementsSeqs getS2() {
		return s2;
	}

	public void setS2(StatementsSeqs s2) {
		this.s2 = s2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return b + " s1: " + s1 + "-- s2: " + s2;
	}

}
