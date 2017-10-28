package programAnalysis.Declarations;

public class IntArray extends Declarations {

	private String type;
	private String arrayName;
	private int index;
	
	public IntArray() {
		super();
	}
	public IntArray(String arrayName, int index) {
		super();
		this.arrayName = arrayName;
		this.index = index;
	}
	public IntArray(String type, String arrayName, int index) {
		super();
		this.type = type;
		this.arrayName = arrayName;
		this.index = index;
	}
	
	public String getType() {
		return type;
	}
	public String getArrayName() {
		return arrayName;
	}
	public int getIndex() {
		return index;
	}
	
	
}
