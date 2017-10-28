package programAnalysis.Declarations;

public class DeclarationsSeqs extends Declarations{

	private Declarations d1;
	private Declarations d2;
	private IntArray intArray;
	private IntX intX;
	
	public DeclarationsSeqs() {
		super();
	}
	public DeclarationsSeqs(Declarations d1, Declarations d2) {
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
	public Declarations getD2() {
		return d2;
	}
	public void setD2(Declarations d2) {
		this.d2 = d2;
	}
	public IntArray getIntArray() {
		return intArray;
	}
	public void setIntArray(IntArray intArray) {
		this.intArray = intArray;
	}
	public IntX getIntX() {
		return intX;
	}
	public void setIntX(IntX intX) {
		this.intX = intX;
	}
	
}
