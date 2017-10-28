package programAnalysis.operatiors;

public class Opa extends Operators {
	
	public Opa() {}
	
	public Opa(String add, String min, String multi, String div) {
		super();
		this.add = add;
		this.min = min;
		this.multi = multi;
		this.div = div;
	}

	private String add = "+";
	private String min = "-";
	private String multi = "*";
	private String div = "/";
	
	public enum opas{
		add, min, multi, div;
	}
	
	public String getAdd() {
		return add;
	}

	public String getMin() {
		return min;
	}

	public String getMulti() {
		return multi;
	}

	public String getDiv() {
		return div;
	}
	
}
