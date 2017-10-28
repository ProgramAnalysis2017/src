package programAnalysis.statements;

public class StatementsSeqs extends Statements{

	private Statements s1;
	private Statements s2;
	
	public StatementsSeqs() {
		super();
	}
	public StatementsSeqs(Statements s1, Statements s2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
	}
	public Statements getS1() {
		return s1;
	}
	public void setS1(Statements s1) {
		this.s1 = s1;
	}
	public Statements getS2() {
		return s2;
	}
	public void setS2(Statements s2) {
		this.s2 = s2;
	}
	
}
