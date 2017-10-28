package programAnalysis.Epressions;

public class IntegerN extends Expressions {

	private int n;
	
	public IntegerN(int n) {
		super();
		this.n = n;
	}
	
	public int getN() {
		return n;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return n + "";
	}
}
