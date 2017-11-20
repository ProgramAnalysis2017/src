package programAnalysis.Declarations;

public class IntArray extends Declarations {

	private String type = "int";
	private String arrayName;
	private int size;
	
	public IntArray() {
		super();
	}
	public IntArray(String arrayName, int index) {
		super();
		this.arrayName = arrayName;
		this.size = index;
	}
	public IntArray(String type, String arrayName, int index) {
		super();
		this.type = type;
		this.arrayName = arrayName;
		this.size = index;
	}
	
	public String getType() {
		return type;
	}
	public String getArrayName() {
		return arrayName;
	}
	public int getIndex() {
		return size;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type + " " + arrayName + "[" + size + "]";
	}
}
