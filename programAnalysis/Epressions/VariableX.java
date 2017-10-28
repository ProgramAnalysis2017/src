package programAnalysis.Epressions;

public class VariableX extends Expressions {

	String x;

	public VariableX() {
		super();
	}

	public VariableX(String x) {
		super();
		this.x = x;
	}

	public String getX() {
		return x;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x;
	}
	
}
