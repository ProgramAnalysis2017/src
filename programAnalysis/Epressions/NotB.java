package programAnalysis.Epressions;

public class NotB extends Expressions {

	private String non = "not";
	private Expressions b;
	
	public NotB() {
		super();
	}
	
	public NotB(String non, Expressions b) {
		super();
		this.non = non;
		this.b = b;
	}
	
	public String getNon() {
		return non;
	}
	public Expressions getB() {
		return b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return non + " " + b.toString();
	}
}
