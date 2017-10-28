package programAnalysis.graphs;

public class Kill {

	private String var;
	private String label;
	
	public Kill(String var, String label) {
		super();
		this.var = var;
		this.label = label;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( " + var + " , " + label + " )";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return var.equals( ((Kill) obj).getVar() ) && label.equals( ((Kill) obj).getLabel() );
	}
}
