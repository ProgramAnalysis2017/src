package microC.parsing;

import java.util.ArrayList;

import microC.parsing.MicroCParser.Aexpr1Context;
import microC.parsing.MicroCParser.Aexpr2Context;
import microC.parsing.MicroCParser.Bexpr1Context;
import microC.parsing.MicroCParser.Bexpr2Context;
import microC.parsing.MicroCParser.DeclContext;
import microC.parsing.MicroCParser.StmtContext;
import programAnalysis.Declarations.Declarations;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.Declarations.IntArray;
import programAnalysis.Declarations.IntX;
import programAnalysis.Epressions.Array;
import programAnalysis.Epressions.ExpressionOperations;
import programAnalysis.Epressions.Expressions;
import programAnalysis.Epressions.False;
import programAnalysis.Epressions.IntegerN;
import programAnalysis.Epressions.NotB;
import programAnalysis.Epressions.True;
import programAnalysis.Epressions.VariableX;
import programAnalysis.operatiors.Opa;
import programAnalysis.operatiors.Opb;
import programAnalysis.operatiors.Opr;
import programAnalysis.programs.Program;
import programAnalysis.statements.Assignment;
import programAnalysis.statements.AssignmentArray;
import programAnalysis.statements.BlockStmt;
import programAnalysis.statements.Break;
import programAnalysis.statements.Continue;
import programAnalysis.statements.If;
import programAnalysis.statements.IfElse;
import programAnalysis.statements.ReadArray;
import programAnalysis.statements.ReadX;
import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;
import programAnalysis.statements.Write;

public class ProgramVisitor extends MicroCBaseVisitor<Program> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Program visitProgram(MicroCParser.ProgramContext ctx) { 
		Program program = new Program();
		DeclContext dec = ctx.decl();// get all declarations
		StmtContext stm = ctx.stmt();//get all statements
		if(dec != null) {
			DeclarationsSeqs decl = visitDecl(dec);
			program.setDeclarations(decl);
		}
		if(stm != null) {
			StatementsSeqs stmts = visitStmt(stm);
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
	@Override public DeclarationsSeqs visitDecl(MicroCParser.DeclContext ctx) { 
		DeclarationsSeqs decs = new DeclarationsSeqs();	
		Declarations basicDecl = visitBasicDecl(ctx.basicDecl()); 
		decs.setD1(basicDecl);
		if(ctx.decl()!=null){
			decs.setD2( visitDecl(ctx.decl()));
		}		
		return decs; 
	}		
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Declarations visitBasicDecl(MicroCParser.BasicDeclContext ctx) { 		
		Declarations basicDecl = new Declarations();	
		if (ctx.LBRACKET()!=null){
	           String varName = ctx.identifier().getText();
	           int arraySize = visitInteger(ctx.integer()).getN();
	           basicDecl = new IntArray(varName,arraySize);
	           System.out.println(basicDecl.toString());
	    }else{    	
	    	String varName = ctx.identifier().getText();
	    	basicDecl = new IntX(varName);
	    	System.out.println(basicDecl.toString());
	    }	
		return basicDecl;		
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public StatementsSeqs visitStmt(MicroCParser.StmtContext ctx) { 
		StatementsSeqs statementsSeqs = new StatementsSeqs();
		Statements statements = new Statements();
		if(ctx.basicStmt().blockStmt() != null){
			statements = visitBlockStmt(ctx.basicStmt().blockStmt());
		}else{
			statements = visitBasicStmt(ctx.basicStmt());
		}	
		statementsSeqs.setS1(statements);
		if( ctx.stmt()!=null) {
			statementsSeqs.setS2( visitStmt(ctx.stmt()));
		}		
		return statementsSeqs; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitBasicStmt(MicroCParser.BasicStmtContext ctx) { 
		Statements basicStatement = new Statements();
		if(ctx.whileStmt() != null){
			basicStatement = visitWhileStmt(ctx.whileStmt());
		}else if(ctx.ifelseStmt() != null){
			basicStatement = visitIfelseStmt(ctx.ifelseStmt());
		}else if(ctx.readStmt() != null){
			basicStatement = visitReadStmt(ctx.readStmt());
		}else if(ctx.writeStmt() != null){
			basicStatement = visitWriteStmt(ctx.writeStmt());
		}else if(ctx.assignStmt() != null){
			basicStatement = visitAssignStmt(ctx.assignStmt());
		}else if(ctx.breakStmt() != null){
			basicStatement = visitBreakStmt(ctx.breakStmt());
		}else if(ctx.continueStmt() != null){
			basicStatement = visitContinueStmt(ctx.continueStmt());
		}
		return basicStatement; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public While visitWhileStmt(MicroCParser.WhileStmtContext ctx) { 		
		Expressions whileCondition = visitBexpr(ctx.bexpr());	
		//System.out.println(ctx.stmt().getText());
		StatementsSeqs whileBody = visitStmt(ctx.stmt());
		While newWhile = new While(whileCondition,whileBody);
		return newWhile; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitIfelseStmt(MicroCParser.IfelseStmtContext ctx) { 
		Statements ifStatement = new Statements();
		Expressions ifCondition= visitBexpr(ctx.bexpr());
		StatementsSeqs ifBody = visitStmt(ctx.stmt(0));
		if(ctx.ELSE()!= null){
			StatementsSeqs elseBody = visitStmt(ctx.stmt(1));
			ifStatement = new IfElse(ifCondition,ifBody,elseBody);
		}else{
			ifStatement = new If(ifCondition,ifBody);
		}		
		return ifStatement; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr(MicroCParser.BexprContext ctx) { 
		ArrayList<Bexpr1Context> expressions = (ArrayList<Bexpr1Context>) ctx.bexpr1();
		Expressions left_expression = visitBexpr1(expressions.get(0));
		for(int index=1; index<expressions.size(); index++){
			Expressions right_expression = visitBexpr1(expressions.get(index));
			Opb op = new Opb();
			String opb = op.getOr();
			left_expression = new ExpressionOperations(left_expression,opb,right_expression);
		}
		System.out.println(left_expression.toString());
		return left_expression;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr1(MicroCParser.Bexpr1Context ctx) {
		ArrayList<Bexpr2Context> expressions = (ArrayList<Bexpr2Context>) ctx.bexpr2();
		Expressions left_expression = visitBexpr2(expressions.get(0));
		for(int index=1; index<expressions.size(); index++){
			Expressions right_expression = visitBexpr2(expressions.get(index));
			Opb op = new Opb();
			String opb = op.getAnd();
			left_expression = new ExpressionOperations(left_expression,opb,right_expression);
		}
		return left_expression;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitBexpr2(MicroCParser.Bexpr2Context ctx) { 
		Expressions boolExpression = new Expressions();
		if(ctx.NOT()!= null){
			boolExpression = new NotB("not",visitBexpr(ctx.bexpr()));
			System.out.println("Ignore this.");
		}else if(ctx.TRUE()!= null){
			boolExpression = new True();
		}else if(ctx.FALSE()!= null){
			boolExpression = new False();
		}else if(ctx.LPAREN()!= null){
			boolExpression = visitBexpr(ctx.bexpr());
		}else if(ctx.opr()!= null){
			//System.out.println("boolExpression: "+ctx.opr().getText());
			Opr pbr = new Opr();
			if(ctx.opr().GT()!=null){				
				String opr_GT = pbr.getGreaterThan();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_GT,visitAexpr(ctx.aexpr(1)));
			}else if(ctx.opr().GE()!=null){
				String opr_GE = pbr.getGreaterEquals();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_GE,visitAexpr(ctx.aexpr(1)));
			}else if(ctx.opr().LT()!=null){
				String opr_LT = pbr.getLessThan();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_LT,visitAexpr(ctx.aexpr(1)));
			}else if(ctx.opr().LE()!=null){
				String opr_LE = pbr.getLessEquals();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_LE,visitAexpr(ctx.aexpr(1)));
			}else if(ctx.opr().EQ()!=null){
				String opr_EQ = pbr.getEuqals();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_EQ,visitAexpr(ctx.aexpr(1)));
			}else if(ctx.opr().NEQ()!=null){
				String opr_NEQ = pbr.getNotEquals();				
				boolExpression = new ExpressionOperations(visitAexpr(ctx.aexpr(0)),opr_NEQ,visitAexpr(ctx.aexpr(1)));
			}
		}
		return boolExpression; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr(MicroCParser.AexprContext ctx) {
		ArrayList<Aexpr1Context> expressions = (ArrayList<Aexpr1Context>) ctx.aexpr1();
		Expressions left_expression = visitAexpr1(expressions.get(0));
		for(int index=1; index<expressions.size(); index++){
			Expressions right_expression = visitAexpr1(expressions.get(index));
			Opa op = new Opa();
			String opa;
			if(ctx.PLUS(index-1) != null){			
				opa = op.getAdd();
			}else{
				opa = op.getMin();
			}
			left_expression = new ExpressionOperations(left_expression,opa,right_expression);
		}
		//System.out.println(left_expression.toString());
		return left_expression;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr1(MicroCParser.Aexpr1Context ctx) { 
		ArrayList<Aexpr2Context> expressions = (ArrayList<Aexpr2Context>) ctx.aexpr2();
		Expressions left_expression = visitAexpr2(expressions.get(0));
		for(int index=1; index<expressions.size(); index++){
			Expressions right_expression = visitAexpr2(expressions.get(index));
			Opa op = new Opa();
			String opa;
			if(ctx.MUL(index-1) != null){			
				opa = op.getMulti();
			}else{
				opa = op.getDiv();
			}
			left_expression = new ExpressionOperations(left_expression,opa,right_expression);
		}	
		return left_expression;
	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr2(MicroCParser.Aexpr2Context ctx) { 
		Expressions expression = new Expressions();
		expression = visitAexpr3(ctx.aexpr3());
		return expression; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr3(MicroCParser.Aexpr3Context ctx) { 
		Expressions expression = new Expressions();
		if(ctx.INTEGER() != null){
			expression = new IntegerN(Integer.parseInt(ctx.getText()));
		}else if(ctx.IDENTIFIER() != null){
			if(ctx.LBRACKET()!= null){
				String arrayName = ctx.IDENTIFIER().getText();
				expression = new Array(arrayName,visitAexpr(ctx.aexpr()));
			}else{
				expression = new VariableX(ctx.IDENTIFIER().getText());
			}
		}else if(ctx.LPAREN() != null){
			expression = visitAexpr(ctx.aexpr());
		}		
		return expression; 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitReadStmt(MicroCParser.ReadStmtContext ctx) { 
		Statements readStatement = new Statements();		
		if (ctx.LBRACKET()!= null) {
			String arrayName = ctx.identifier().getText();
			Expressions indexExp = visitAexpr(ctx.aexpr());
			readStatement = new ReadArray(arrayName,indexExp);
	        System.out.println(readStatement.toString());
	    }else{    	
	    	String varName = ctx.identifier().getText();
	    	readStatement= new ReadX(varName);
	    	System.out.println(readStatement.toString());   
	    }		
		return readStatement; 		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitWriteStmt(MicroCParser.WriteStmtContext ctx) { 
		Statements statement = new Statements();
		Expressions exp = visitAexpr(ctx.aexpr());			
		statement = new Write(exp);	
		System.out.println(statement.toString());		
		return statement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitAssignStmt(MicroCParser.AssignStmtContext ctx) { 
		Statements statement = new Statements();	
		String rightSideStr = ctx.identifier().getText();
		if(ctx.LBRACKET()!= null){
			Expressions rightSideExpressions = visitAexpr(ctx.aexpr(1));
			Expressions indexExp = visitAexpr(ctx.aexpr(0));
			statement = new AssignmentArray(rightSideStr,indexExp,rightSideExpressions);
			System.out.println(statement.toString());
		}else{
			Expressions rightSideExpressions = visitAexpr(ctx.aexpr(0));
			statement = new Assignment(rightSideStr,rightSideExpressions);	
	    	System.out.println(statement.toString());
		}	
		return statement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Break visitBreakStmt(MicroCParser.BreakStmtContext ctx) {
		Break breakStatement = new Break();
		System.out.println(breakStatement.toString());
		return breakStatement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Continue visitContinueStmt(MicroCParser.ContinueStmtContext ctx) { 
		Continue continueStatement = new Continue();
		System.out.println(continueStatement.toString());
		return continueStatement; 		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public BlockStmt visitBlockStmt(MicroCParser.BlockStmtContext ctx) { 
		BlockStmt statements = new BlockStmt();
		DeclarationsSeqs decs = new DeclarationsSeqs();
		StatementsSeqs stms = new StatementsSeqs();
		if(ctx.decl()!= null){				
			decs = visitDecl(ctx.decl());
			statements.setDeclarations(decs);
		}
		if(ctx.stmt()!= null){			
			stms = visitStmt(ctx.stmt());
		}			
		statements.setStatements(stms);
		return statements; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public IntegerN visitInteger(MicroCParser.IntegerContext ctx) { 		
		IntegerN integerN = new IntegerN(Integer.parseInt(ctx.getText()));
		return integerN; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIdentifier(MicroCParser.IdentifierContext ctx) { 
		String indentifier = ctx.getText();
		return indentifier; }
}
