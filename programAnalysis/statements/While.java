package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class While extends Statements {

	private Expressions b;
	private StatementsSeqs s0;
	
	public While() {}

	public While(Expressions b, StatementsSeqs s0) {
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
