package programAnalysis.graphs;

public class Flow {

	private int label1;
	private int label2;
	
	public Flow(int label1, int label2) {
		super();
		this.label1 = label1;
		this.label2 = label2;
	}
	
	public int getLabel1() {
		return label1;
	}
	public void setLabel1(int label1) {
		this.label1 = label1;
	}
	public int getLabel2() {
		return label2;
	}
	public void setLabel2(int label2) {
		this.label2 = label2;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return label1 == ((Flow) obj).getLabel1() && label2 == ((Flow) obj).getLabel2() ;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( " + label1 + " , " + label2 + " )";
	}
	
}
