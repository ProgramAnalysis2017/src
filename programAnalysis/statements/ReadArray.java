package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class ReadArray extends Statements {
	private String read = "read";
	private String arrayName;
	private int index;
	private Expressions a;
	
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	
	public String getArrayName() {
		return arrayName;
	}
	public void setArrayName(String arrayName) {
		this.arrayName = arrayName;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Expressions getA() {
		return a;
	}
	public void setA(Expressions a) {
		this.a = a;
	}
}
