package programAnalysis.operatiors;

public class Opr extends Operators {
	
	private String less = "<";
	private String greater = ">";
	private String lessThan = "<=";
	private String greaterThan = ">=" ;
	private String euqals = "==";
	private String notEquals = "!=";
	
	public Opr() {}
	
	public Opr(String less, String greater, String lessThan, String greaterThan, String euqals, String notEquals) {
		super();
		this.less = less;
		this.greater = greater;
		this.lessThan = lessThan;
		this.greaterThan = greaterThan;
		this.euqals = euqals;
		this.notEquals = notEquals;
	}

	
	public enum oprs{
		less, greater, lessThan, greaterThan,euqals,notEquals;
	}

	public String getLess() {
		return less;
	}

	public String getGreater() {
		return greater;
	}

	public String getLessThan() {
		return lessThan;
	}

	public String getGreaterThan() {
		return greaterThan;
	}

	public String getEuqals() {
		return euqals;
	}

	public String getNotEquals() {
		return notEquals;
	}
	
}
