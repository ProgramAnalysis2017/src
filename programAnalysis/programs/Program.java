package programAnalysis.programs;

import programAnalysis.Declarations.Declarations;
import programAnalysis.statements.Statements;

public class Program {

	private Declarations declarations;
	private Statements statements;
	
	public Program() {
		super();
	}
	public Program(Declarations declarations, Statements statements) {
		super();
		this.declarations = declarations;
		this.statements = statements;
	}
	public Declarations getDeclarations() {
		return declarations;
	}
	public void setDeclarations(Declarations declarations) {
		this.declarations = declarations;
	}
	public Statements getStatements() {
		return statements;
	}
	public void setStatements(Statements statements) {
		this.statements = statements;
	}
	
}
