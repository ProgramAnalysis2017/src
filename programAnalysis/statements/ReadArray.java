package programAnalysis.statements;

import programAnalysis.Epressions.Expressions;

public class ReadArray extends Statements {
	private String read = "read";
	private String arrayName;
	//private int index;
	private Expressions a;
	
	public ReadArray(String arrayName, Expressions a){
		super();
		this.arrayName = arrayName;
		this.a = a;
	}
	
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
//	public int getIndex() {
//		return index;
//	}
//	public void setIndex(int index) {
//		this.index = index;
//	}
	public Expressions getA() {
		return a;
	}
	public void setA(Expressions a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return read + " " + arrayName + "[" + a + "]";
	}
}
