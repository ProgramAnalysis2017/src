package microC.parsing;

import microC.parsing.MicroCParser.DeclContext;
import microC.parsing.MicroCParser.StmtContext;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.programs.Program;
import programAnalysis.statements.StatementsSeqs;

public class MyVisitor<T> extends MicroCBaseVisitor<T> {

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAexpr(MicroCParser.AexprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAexpr1(MicroCParser.Aexpr1Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAexpr2(MicroCParser.Aexpr2Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAexpr3(MicroCParser.Aexpr3Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBexpr(MicroCParser.BexprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBexpr1(MicroCParser.Bexpr1Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBexpr2(MicroCParser.Bexpr2Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOpr(MicroCParser.OprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBasicDecl(MicroCParser.BasicDeclContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public DeclarationsSeqs visitDecl(MicroCParser.DeclContext ctx) { 
		//DeclarationsSeqs decs = new DeclarationsSeqs();
		Declarations decs = new Declarations();
		if (ctx.getText() != null) { 
			//System.out.println("not null");
			decs.setD1();
			decs.getD1();
			ctx.basicDecl().getText();
		}
/*		System.out.println(ctx.getText());				//entire declaration
		String declaration = ctx.basicDecl().getText();	//get the first declaration and remove from the list
		System.out.println(declaration);
		System.out.println(ctx.decl().getText());	   //rest declaration of the list
*/		return decs; 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBasicStmt(MicroCParser.BasicStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public StatementsSeqs visitStmt(MicroCParser.StmtContext ctx) { 
		StatementsSeqs statements = new StatementsSeqs();
		return statements; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAssignStmt(MicroCParser.AssignStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitContinueStmt(MicroCParser.ContinueStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitReadStmt(MicroCParser.ReadStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBreakStmt(MicroCParser.BreakStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWriteStmt(MicroCParser.WriteStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIfelseStmt(MicroCParser.IfelseStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWhileStmt(MicroCParser.WhileStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBlockStmt(MicroCParser.BlockStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Program visitProgram(MicroCParser.ProgramContext ctx) { 
		//System.out.println(ctx.decl().getText());//the result is:" inti;intx;inty;intz;intA[10]; "
		//System.out.println(ctx.stmt().getText());// the result is: " while(i<10){readA[i];i=i+1;}i=0;while(notfalse){if(A[i]+1>=0){x=x+A[i];i=i+1;}else{i=i+1;break;}y=y+1;}writex/y;readz; "
		Program program = new Program();
		DeclContext dec = ctx.decl();// get all declarations
		StmtContext stmt = ctx.stmt();//get all statements
		if(dec != null) {
			DeclarationsSeqs decs = visitDecl(dec);
			program.setDeclarations(decs);
		}
		if(stmt != null) {
			StatementsSeqs stmts = visitStmt(stmt);
			program.setStatements(stmts);
		}
		
		return program; 
	}
	/**
	 * {@inheritDoc}
	 * 
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIdentifier(MicroCParser.IdentifierContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public IntX visitInteger(MicroCParser.IntegerContext ctx) { return visitChildren(ctx); }
	
}
