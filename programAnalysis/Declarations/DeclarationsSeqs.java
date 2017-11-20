package programAnalysis.Declarations;

public class DeclarationsSeqs extends Declarations{

	private Declarations d1;
	private DeclarationsSeqs d2;
	
	public DeclarationsSeqs() {
		super();
	}
	public DeclarationsSeqs(Declarations d1, DeclarationsSeqs d2) {
		super();
		this.d1 = d1;
		this.d2 = d2;
	}
	public Declarations getD1() {
		return d1;
	}
	public void setD1(Declarations d1) {
		this.d1 = d1;
	}
	public DeclarationsSeqs getD2() {
		return d2;
	}
	public void setD2(DeclarationsSeqs d2) {
		this.d2 = d2;
	}
	
}
