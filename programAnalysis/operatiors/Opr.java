package programAnalysis.operatiors;

public class Opr extends Operators {
	
	private String lessThan = "<";
	private String greaterThan = ">";
	private String lessEquals = "<=";
	private String greaterEquals = ">=" ;
	private String euqals = "==";
	private String notEquals = "!=";
	
	public Opr() {}
	
	public Opr(String lessThan, String greaterThan, String lessEquals, String greaterEquals, String euqals, String notEquals) {
		super();
		this.lessThan = lessThan;
		this.greaterThan = greaterThan;
		this.lessEquals = lessEquals;
		this.greaterEquals = greaterEquals;
		this.euqals = euqals;
		this.notEquals = notEquals;
	}

	
	public String getLessThan() {
		return lessThan;
	}

	public void setLessThan(String lessThan) {
		this.lessThan = lessThan;
	}

	public String getGreaterThan() {
		return greaterThan;
	}

	public void setGreaterThan(String greaterThan) {
		this.greaterThan = greaterThan;
	}

	public String getLessEquals() {
		return lessEquals;
	}

	public void setLessEquals(String lessEquals) {
		this.lessEquals = lessEquals;
	}

	public String getGreaterEquals() {
		return greaterEquals;
	}

	public void setGreaterEquals(String greaterEquals) {
		this.greaterEquals = greaterEquals;
	}

	public String getEuqals() {
		return euqals;
	}

	public void setEuqals(String euqals) {
		this.euqals = euqals;
	}

	public String getNotEquals() {
		return notEquals;
	}

	public void setNotEquals(String notEquals) {
		this.notEquals = notEquals;
	}


	public enum oprs{
		lessThan, greaterThan, lessEquals, greaterEquals,euqals,notEquals;
	}


	
}
