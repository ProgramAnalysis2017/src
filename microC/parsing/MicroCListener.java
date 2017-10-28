// Generated from .\src\MicroC_language\parsing\MicroC.g4 by ANTLR 4.7
package microC.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroCParser}.
 */
public interface MicroCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroCParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(MicroCParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(MicroCParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void enterAexpr1(MicroCParser.Aexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#aexpr1}.
	 * @param ctx the parse tree
	 */
	void exitAexpr1(MicroCParser.Aexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void enterAexpr2(MicroCParser.Aexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#aexpr2}.
	 * @param ctx the parse tree
	 */
	void exitAexpr2(MicroCParser.Aexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void enterAexpr3(MicroCParser.Aexpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#aexpr3}.
	 * @param ctx the parse tree
	 */
	void exitAexpr3(MicroCParser.Aexpr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(MicroCParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(MicroCParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#bexpr1}.
	 * @param ctx the parse tree
	 */
	void enterBexpr1(MicroCParser.Bexpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#bexpr1}.
	 * @param ctx the parse tree
	 */
	void exitBexpr1(MicroCParser.Bexpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#bexpr2}.
	 * @param ctx the parse tree
	 */
	void enterBexpr2(MicroCParser.Bexpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#bexpr2}.
	 * @param ctx the parse tree
	 */
	void exitBexpr2(MicroCParser.Bexpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#opr}.
	 * @param ctx the parse tree
	 */
	void enterOpr(MicroCParser.OprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#opr}.
	 * @param ctx the parse tree
	 */
	void exitOpr(MicroCParser.OprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#basicDecl}.
	 * @param ctx the parse tree
	 */
	void enterBasicDecl(MicroCParser.BasicDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#basicDecl}.
	 * @param ctx the parse tree
	 */
	void exitBasicDecl(MicroCParser.BasicDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MicroCParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MicroCParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#basicStmt}.
	 * @param ctx the parse tree
	 */
	void enterBasicStmt(MicroCParser.BasicStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#basicStmt}.
	 * @param ctx the parse tree
	 */
	void exitBasicStmt(MicroCParser.BasicStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MicroCParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MicroCParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(MicroCParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(MicroCParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(MicroCParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#continueStmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(MicroCParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(MicroCParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(MicroCParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(MicroCParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(MicroCParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(MicroCParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(MicroCParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#ifelseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfelseStmt(MicroCParser.IfelseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#ifelseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfelseStmt(MicroCParser.IfelseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MicroCParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MicroCParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MicroCParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MicroCParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MicroCParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MicroCParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(MicroCParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(MicroCParser.IntegerContext ctx);
}