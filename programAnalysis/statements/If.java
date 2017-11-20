package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class If extends Statements {

	private Expressions b;
	private StatementsSeqs s0;
	
	public If() {}

	public If(Expressions b, StatementsSeqs s0) {
		super();
		this.b = b;
		this.s0 = s0;
	}

	public Expressions getB() {
		return b;
	}

	public void setB(Expressions b) {
		this.b = b;
	}

	public StatementsSeqs getS0() {
		return s0;
	}

	public void setS0(StatementsSeqs s0) {
		this.s0 = s0;
	}

	
}
