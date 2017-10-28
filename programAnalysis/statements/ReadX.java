package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class ReadX extends Statements{
	private String read = "read";
	private String x;
	private Expressions a;
	
	
	public ReadX(String read, String x) {
		super();
		this.read = read;
		this.x = x;
	}
	public ReadX(String read, String x, Expressions a) {
		super();
		this.read = read;
		this.x = x;
		this.a = a;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public Expressions getA() {
		return a;
	}
	public void setA(Expressions a) {
		this.a = a;
	}
}
