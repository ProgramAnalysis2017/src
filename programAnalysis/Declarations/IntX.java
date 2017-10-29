package programAnalysis.Declarations;

public class IntX extends Declarations {
	
	private String type;
	private String varName;
	private int x;	
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setX(int x) {
		this.x = x;
	}

	public IntX() {}

	public IntX(String type, String varName, int x) {
		super();
		this.type = type;
		this.varName = varName;
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
