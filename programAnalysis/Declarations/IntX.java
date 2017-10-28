package programAnalysis.Declarations;

public class IntX extends Declarations {
	
	private String type;
	private int x;
	
	public IntX() {}

	public IntX(String type, int x) {
		super();
		this.type = type;
		this.x = x;
	}
	
	public IntX(int x) {
		super();
		this.x = x;
	}
	
	public String getType() {
		return type;
	}
	public int getX() {
		return x;
	}
}
