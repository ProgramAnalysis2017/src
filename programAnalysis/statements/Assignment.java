package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class Assignment extends Statements {

	private String x;
	private Expressions a;
	
	public Assignment(String x, Expressions a) {
		super();
		this.x = x;
		this.a = a;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " := " + a;
	}
	public String getX() {
		return x;
	}
	public Expressions getA() {
		return a;
	}

	public void setX(String x) {
		this.x = x;
	}

	public void setA(Expressions a) {
		this.a = a;
	}
	
}
