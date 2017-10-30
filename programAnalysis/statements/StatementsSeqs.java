package programAnalysis.statements;

public class StatementsSeqs extends Statements{

	private Statements s1;
	private Statements s2;
	
	private Assignment assignment;
	private AssignmentArray assignmentArray;
	private Break b;
	private Continue c;
	private If ifInstance;
	private IfElse ifElse;
	private ReadArray readArray;
	private ReadX readX;
	private While whileInstance;
	private Write write;
	
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
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public AssignmentArray getAssignmentArray() {
		return assignmentArray;
	}
	public void setAssignmentArray(AssignmentArray assignmentArray) {
		this.assignmentArray = assignmentArray;
	}
	public Break getB() {
		return b;
	}
	public void setB(Break b) {
		this.b = b;
	}
	public Continue getC() {
		return c;
	}
	public void setC(Continue c) {
		this.c = c;
	}
	public If getIfInstance() {
		return ifInstance;
	}
	public void setIfInstance(If ifInstance) {
		this.ifInstance = ifInstance;
	}
	public IfElse getIfElse() {
		return ifElse;
	}
	public void setIfElse(IfElse ifElse) {
		this.ifElse = ifElse;
	}
	public ReadArray getReadArray() {
		return readArray;
	}
	public void setReadArray(ReadArray readArray) {
		this.readArray = readArray;
	}
	public ReadX getReadX() {
		return readX;
	}
	public void setReadX(ReadX readX) {
		this.readX = readX;
	}
	public While getWhileInstance() {
		return whileInstance;
	}
	public void setWhileInstance(While whileInstance) {
		this.whileInstance = whileInstance;
	}
	public Write getWrite() {
		return write;
	}
	public void setWrite(Write write) {
		this.write = write;
	}
	
}
