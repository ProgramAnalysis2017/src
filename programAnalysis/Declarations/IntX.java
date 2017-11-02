package programAnalysis.Declarations;

public class IntX extends Declarations {
	
	private String type = "int";
	private String varName;
	private int x = 0;	
	
	public IntX() {
		super();
	}
	
	public IntX(String varName) {
		super();
		this.varName = varName;
	}
	
	public IntX(String type, String varName) {
		super();
		this.type = type;
		this.varName = varName;
	}
	
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

	public String getType() {
		return type;
	}
	public int getX() {
		return x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return type + " " + varName;
	}
}
