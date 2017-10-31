package programAnalysis.operatiors;

public class Opb extends Operators {
	
	public Opb() {}
	
	public Opb(String and, String or) {
		super();
		this.and = and;
		this.or = or;
	}
	
	private String and = "&";
	private String or = "|";
	
	public enum opbs{
		and, or;
	}

	public String getAnd() {
		return and;
	}

	public String getOr() {
		return or;
	}
}
