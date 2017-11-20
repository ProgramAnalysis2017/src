package programAnalysis.statements;

import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;

public class BlockStmt extends Statements{
	private DeclarationsSeqs declarations;
	private StatementsSeqs statements;
	
	public BlockStmt() {
		super();
	}
	public BlockStmt(DeclarationsSeqs declarations, StatementsSeqs statements) {
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
