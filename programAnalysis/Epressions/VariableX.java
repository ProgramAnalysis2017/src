package programAnalysis.Epressions;

public class VariableX extends Expressions {

	private String x;
	private int val = 0;

	public VariableX() {
		super();
	}

	public VariableX(String x) {
		super();
		this.x = x;
	}
	
	public VariableX(String x, int val) {
		super();
		this.x = x;
		this.val = val;
	}

	public String ExpressionOperations() {
		return x;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}
	
}
