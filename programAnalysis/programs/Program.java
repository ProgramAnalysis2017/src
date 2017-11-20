package programAnalysis.programs;

import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.statements.StatementsSeqs;

public class Program {

	private DeclarationsSeqs declarations;
	private StatementsSeqs statements;
	
	public Program() {
		super();
	}
	public Program(DeclarationsSeqs declarations, StatementsSeqs statements) {
		super();
		this.declarations = declarations;
		this.statements = statements;
	}
	public Declarations getDeclarations() {
		return declarations;
	}
	public void setDeclarations(DeclarationsSeqs declarations) {
		this.declarations = declarations;
	}
	public StatementsSeqs getStatements() {
		return statements;
	}
	public void setStatements(StatementsSeqs statements) {
		this.statements = statements;
	}
	
}
