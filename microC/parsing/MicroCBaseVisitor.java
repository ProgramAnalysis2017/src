// Generated from .\src\MicroC_language\parsing\MicroC.g4 by ANTLR 4.7
package microC.parsing;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.Epressions.Expressions;
import programAnalysis.Epressions.IntegerN;
import programAnalysis.statements.BlockStmt;
import programAnalysis.statements.Break;
import programAnalysis.statements.Continue;
import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;

/**
 * This class provides an empty implementation of {@link MicroCVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class MicroCBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MicroCVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr(MicroCParser.AexprContext ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr1(MicroCParser.Aexpr1Context ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr2(MicroCParser.Aexpr2Context ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr3(MicroCParser.Aexpr3Context ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr(MicroCParser.BexprContext ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr1(MicroCParser.Bexpr1Context ctx) { return (Expressions) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr2(MicroCParser.Bexpr2Context ctx) { return (Expressions) visitChildren(ctx); }
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
	@Override public Declarations visitBasicDecl(MicroCParser.BasicDeclContext ctx) { return (Declarations) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public DeclarationsSeqs visitDecl(MicroCParser.DeclContext ctx) { return (DeclarationsSeqs) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitBasicStmt(MicroCParser.BasicStmtContext ctx) { return (Statements) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public StatementsSeqs visitStmt(MicroCParser.StmtContext ctx) { return (StatementsSeqs) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitAssignStmt(MicroCParser.AssignStmtContext ctx) { return (Statements) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Continue visitContinueStmt(MicroCParser.ContinueStmtContext ctx) { return (Continue) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitReadStmt(MicroCParser.ReadStmtContext ctx) { return (Statements) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Break visitBreakStmt(MicroCParser.BreakStmtContext ctx) { return (Break) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitWriteStmt(MicroCParser.WriteStmtContext ctx) { return (Statements) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitIfelseStmt(MicroCParser.IfelseStmtContext ctx) { return (Statements) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public While visitWhileStmt(MicroCParser.WhileStmtContext ctx) { return (While) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public BlockStmt visitBlockStmt(MicroCParser.BlockStmtContext ctx) { return (BlockStmt) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProgram(MicroCParser.ProgramContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIdentifier(MicroCParser.IdentifierContext ctx) { return (String) visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public IntegerN visitInteger(MicroCParser.IntegerContext ctx) { return (IntegerN) visitChildren(ctx); }
}