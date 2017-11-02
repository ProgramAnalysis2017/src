package programAnalysis.Epressions;

public class Array extends Expressions {

	private String arrayName;
	private Expressions index;
	
	public Array() {
		super();
	}
	
	public Array(String arrayName, Expressions index) {
		super();
		this.arrayName = arrayName;
		this.index = index;
	}
	
	public String getArrayName() {
		return arrayName;
	}
	public Expressions getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return arrayName+"["+index+"]";
	}
	
}
