package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class Write extends Statements{

	private String write = "write";
	private Expressions a;
	
	public Write(String write, Expressions a) {
		super();
		this.write = write;
		this.a = a;
	}
	public Write(Expressions a) {
		super();
		this.a = a;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public Expressions getA() {
		return a;
	}
	public void setA(Expressions a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return write + " " + a;
	}
}
