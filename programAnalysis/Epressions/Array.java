package programAnalysis.Epressions;

public class Array extends Expressions {

	private String arrayName;
	private int index;
	
	public Array() {
		super();
	}
	
	public Array(String arrayName, int index) {
		super();
		this.arrayName = arrayName;
		this.index = index;
	}
	
	public String getArrayName() {
		return arrayName;
	}
	public int getIndex() {
		return index;
	}
	
}
