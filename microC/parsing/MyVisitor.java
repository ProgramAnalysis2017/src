package microC.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class MyVisitor<T> extends MicroCBaseVisitor<T> {

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Expressions visitAexpr(MicroCParser.AexprContext ctx) { 
		String exp = ctx.getText();
		Expressions expression = getExpressions(exp);								
		return expression;	
	}
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
	@Override public Expressions visitBexpr(MicroCParser.BexprContext ctx) { 
		Expressions boolExpression = new Expressions();
		String expressionStr = ctx.getText();	
		Expressions expression = getBoolExpression(expressionStr);		
		System.out.println(expression.toString()); 
		return boolExpression; 
	}
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
	@Override public Declarations visitBasicDecl(MicroCParser.BasicDeclContext ctx) { 
		String basicDeclStr = ctx.getText();
		//System.out.println(basicDeclStr);			
		Declarations basicDecl = new Declarations();	
		Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
		Matcher matcher = pattern.matcher(basicDeclStr);
		if (!matcher.matches()) {
	           String arraySizeStr = basicDeclStr.substring(basicDeclStr.indexOf("[") + 1, basicDeclStr.indexOf("]"));
	           String varName = ctx.identifier().getText();
	           int arraySize = Integer.parseInt(arraySizeStr);
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
	@Override public DeclarationsSeqs visitDecl(MicroCParser.DeclContext ctx) { 
		DeclarationsSeqs decs = new DeclarationsSeqs();
		Declarations basicDecl= visitBasicDecl(ctx.basicDecl());
		decs.setD1(basicDecl);
		if( null != ctx.decl()) {
			decs.setD2( visitDecl(ctx.decl()) );
		}		
		return decs; 	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitBasicStmt(MicroCParser.BasicStmtContext ctx) { 
		Statements basicStatement = new Statements();
		String statement = ctx.getText();
		//System.out.println(statement);
		if(statement.toLowerCase().startsWith("while")){
			basicStatement = visitWhileStmt(ctx.whileStmt());
		}else if(statement.toLowerCase().startsWith("if")){
			basicStatement = visitIfelseStmt(ctx.ifelseStmt());		
		}else if(statement.toLowerCase().startsWith("read")){	
			basicStatement = visitReadStmt(ctx.readStmt());			
		}else if(statement.toLowerCase().startsWith("write")){
			basicStatement = visitWriteStmt(ctx.writeStmt());		
		}else if(statement.toLowerCase().startsWith("continue")){
			basicStatement = visitContinueStmt(ctx.continueStmt());
		}else if(statement.toLowerCase().startsWith("break")){
			basicStatement = visitBreakStmt(ctx.breakStmt());
		}else{	
			// the rest blocks are assignments
			basicStatement = visitAssignStmt(ctx.assignStmt());		
		}		
		return basicStatement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public StatementsSeqs visitStmt(MicroCParser.StmtContext ctx) { 
		StatementsSeqs statements = new StatementsSeqs();
		Statements basicStatement = visitBasicStmt(ctx.basicStmt());
		statements.setS1(basicStatement);
		if( null != ctx.stmt()) {
			statements.setS1( visitStmt(ctx.stmt()));
		}		
		return statements; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitAssignStmt(MicroCParser.AssignStmtContext ctx) { 
		Statements statement = new Statements();	
		String assignmentStr =  ctx.getText();
		String leftSideStr = ctx.identifier().getText();
		//System.out.println(assignmentStr);					
		String basicAssignment = assignmentStr.substring(0, assignmentStr.indexOf(";"));			
		Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
		Matcher matcher = pattern.matcher(basicAssignment);
		if (!matcher.matches()) {
			String rightSideStr = basicAssignment.substring(basicAssignment.indexOf("=") + 1);				
			Expressions exp = getExpressions(rightSideStr);				
			Matcher localMatcher = pattern.matcher(leftSideStr);
			if (!localMatcher.matches()) {			
				String arrayName = leftSideStr.substring(0, leftSideStr.indexOf("["));
	            String arrayIndexStr = leftSideStr.substring(leftSideStr.indexOf("[") + 1, leftSideStr.indexOf("]"));	            
	            Expressions arrayIndex = getExpressions(arrayIndexStr);            
	            statement = new AssignmentArray(arrayName,arrayIndex,exp); 
	            System.out.println(statement.toString());
	            
		    }else{			
		    	statement = new Assignment(leftSideStr,exp);	
		    	System.out.println(statement.toString());
		    }
		}		
		return statement; 
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
	@Override public Statements visitReadStmt(MicroCParser.ReadStmtContext ctx) { 
		String readStatementstr = ctx.getText();
		Statements readStatement = new Statements();		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
		Matcher matcher = pattern.matcher(readStatementstr);
		if (!matcher.matches()) {
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
	@Override public Break visitBreakStmt(MicroCParser.BreakStmtContext ctx) {
		Break breakStatement = new Break();
		System.out.println(breakStatement);
		return breakStatement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Statements visitWriteStmt(MicroCParser.WriteStmtContext ctx) { 
		Statements statement = new Statements();
		String writeStatementStr = ctx.getText();
		String expStr = writeStatementStr.substring(5,writeStatementStr.indexOf(";"));
		Expressions exp = getExpressions(expStr);			
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
	@Override public Statements visitIfelseStmt(MicroCParser.IfelseStmtContext ctx) { 
		System.out.println("if");
		Statements ifStatement = new Statements();
		String IfstatementStr = ctx.getText();
		String ifConditionStr = ctx.bexpr().getText();
		Expressions ifCondition= visitBexpr(ctx.bexpr());
		StatementsSeqs ifBody = visitStmt(ctx.stmt(0));
		String s0 = ctx.stmt(0).getText();
		String restBlocks_afters0 = IfstatementStr.substring(ifConditionStr.length() + s0.length() + 6);
		boolean ifElse = false;
		if((restBlocks_afters0.length() > 0) && restBlocks_afters0.toLowerCase().startsWith("else")){
			ifElse = true;
		}
		if(!ifElse){			
			ifStatement = new If(ifCondition,ifBody);
			//System.out.println("end if");
		}else{
			StatementsSeqs elseBody = visitStmt(ctx.stmt(1));
			ifStatement = new IfElse(ifCondition,ifBody,elseBody);
			//System.out.println("end if");
		}	
		
		return ifStatement; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public While visitWhileStmt(MicroCParser.WhileStmtContext ctx) { 		
		//System.out.println("While");
		Expressions whileCondition = visitBexpr(ctx.bexpr());	
		StatementsSeqs whileBody = visitStmt(ctx.stmt());
		While newWhile = new While();
		newWhile.setB(whileCondition);
		newWhile.setS0(whileBody);
		//System.out.println("endWhile");
		return newWhile; 
	}
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
	@Override public T visitInteger(MicroCParser.IntegerContext ctx) { return visitChildren(ctx); }
	
	public String foundArrayIndex(String body){
		String temp_body = body;
		List<Integer> indexsLeft = new ArrayList<Integer>();
		List<Integer> indexsRight = new ArrayList<Integer>();
		boolean foundBody = true;
		boolean firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf("[")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsLeft.add(temp_body.indexOf("["));
				}else{
					indexsLeft.add(temp_body.indexOf("[")+indexsLeft.get(indexsLeft.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf("[") + 1);
			}else{
				foundBody = false;
			} 
		}
		temp_body = body;
		foundBody = true;
		firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf("]")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsRight.add(temp_body.indexOf("]"));
				}else{
					indexsRight.add(temp_body.indexOf("]")+indexsRight.get(indexsRight.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf("]") + 1);
			}else{
				foundBody = false;
			} 
		}
		int counter1 = 0;
		int counter2 = 0;
		int start = 0;
		boolean notFound = true;
		while(notFound){
			counter1 = 0;
			counter2 = 0;
			for(int index : indexsLeft){
				if(index < indexsRight.get(start)){
					counter1++;
				}
			}
			for(int index : indexsLeft){
				if(index < indexsRight.get(counter1-1)){
					counter2++;
				}
			}
			if(counter1 == counter2){
				notFound = false;
			}
			start++;
		}
		return body.substring(indexsLeft.get(0)+1, indexsRight.get(counter1-1));	
	}
	
	public Expressions getBoolExpression(String boolExp){
		Expressions expression = new Expressions();
		if((boolExp.indexOf("&")>=0)){
			String firstExpStr = boolExp.substring(0, boolExp.indexOf("&"));
			String secondExpStr = boolExp.substring(boolExp.indexOf("&")+1);
			Expressions firstExp;
			Expressions secondExp;
			
			if (firstExpStr.equals("ture")){
				firstExp = new True();	
			}else{
				firstExp = new False();
			}
			
			if (secondExpStr.equals("ture")){
				secondExp = new True();	
			}else{
				secondExp = new False();
			}

			Opb op = new Opb();
			String op_bool = op.getAnd();
			expression = new ExpressionOperations(firstExp,op_bool,secondExp);
		}else if((boolExp.indexOf("|")>=0)){
			String firstExpStr = boolExp.substring(0, boolExp.indexOf("|"));
			String secondExpStr = boolExp.substring(boolExp.indexOf("|")+1);
			Expressions firstExp;
			Expressions secondExp;
			
			if (firstExpStr.equals("ture")){
				firstExp = new True();	
			}else{
				firstExp = new False();
			}
			
			if (secondExpStr.equals("ture")){
				secondExp = new True();	
			}else{
				secondExp = new False();
			}

			Opb op = new Opb();
			String op_bool = op.getOr();
			expression = new ExpressionOperations(firstExp,op_bool,secondExp);
		}else if(boolExp.toLowerCase().startsWith("not")){
			String not = boolExp.substring(0,3);
			String exp = boolExp.substring(3);
			if((exp.indexOf("(")>=0) || (exp.indexOf(")")>=0)){
				exp = exp.substring(exp.indexOf("(") + 1,exp.indexOf(")"));
			}
			Expressions expObj = getExpressions(exp);
			expression = new NotB(not,expObj);
		}
		else{
			if((boolExp.indexOf("<")>=0) && (boolExp.indexOf("=")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf("<"));
				String secondExpStr = boolExp.substring(boolExp.indexOf("=")+1);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_lessEquals = op.getLessEquals();
				expression = new ExpressionOperations(firstExp,op_lessEquals,secondExp);
			}else if((boolExp.indexOf(">")>=0) && (boolExp.indexOf("=")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf(">"));
				String secondExpStr = boolExp.substring(boolExp.indexOf("=")+1);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_greatEuqals = op.getGreaterEquals();
				expression = new ExpressionOperations(firstExp,op_greatEuqals,secondExp);
			}else if((boolExp.indexOf("!")>=0) && (boolExp.indexOf("=")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf("!"));
				String secondExpStr = boolExp.substring(boolExp.indexOf("=")+1);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_notEquals = op.getNotEquals();
				expression = new ExpressionOperations(firstExp,op_notEquals,secondExp);
			}else if((boolExp.indexOf("<")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf("<"));
				String secondExpStr = boolExp.substring(boolExp.indexOf("<")+1);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_lessThan = op.getLessThan();
				expression = new ExpressionOperations(firstExp,op_lessThan,secondExp);
			}else if((boolExp.indexOf(">")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf(">"));
				String secondExpStr = boolExp.substring(boolExp.indexOf(">")+1);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_greatThan = op.getGreaterThan();
				expression = new ExpressionOperations(firstExp,op_greatThan,secondExp);
			}else if((boolExp.indexOf("=")>=0)){
				String firstExpStr = boolExp.substring(0, boolExp.indexOf("="));
				String secondExpStr = boolExp.substring(boolExp.indexOf("=")+2);
				Expressions firstExp;
				Expressions secondExp;
				if(isNumeric(firstExpStr)){
					int n = Integer.parseInt(firstExpStr);
					firstExp = new IntegerN(n);					
				}else{
					firstExp = new VariableX(firstExpStr);
				}
				
				if(isNumeric(secondExpStr)){
					int n = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(n);					
				}else{
					secondExp = new VariableX(firstExpStr);
				}
				Opr op = new Opr();
				String op_equals = op.getEuqals();
				expression = new ExpressionOperations(firstExp,op_equals,secondExp);
			}else if(boolExp.toLowerCase().startsWith("true")){
				expression = new True();		
			}else if(boolExp.toLowerCase().startsWith("false")){
				expression = new False();
			}				
		}
		return expression;
	}
	
	public Expressions getExpressions(String exp){
		Expressions expression = new Expressions();
		List<Integer> indexList = new ArrayList<Integer>();
		int index_array_L = 0;
		int index_array_R = 0;	
		for(int i=0;i<exp.toCharArray().length;i++)
		{
		    if(exp.toCharArray()[i] == '+'){
		    	indexList.add(i);
		    }else if(exp.toCharArray()[i] == '-'){
		    	indexList.add(i);
		    }else if(exp.toCharArray()[i] == '*'){
		    	indexList.add(i);
		    }else if(exp.toCharArray()[i] == '/'){
		    	indexList.add(i);
		    }
		}
		if(indexList.size()>0){
			Collections.sort(indexList);
			index_array_L = exp.indexOf("[");
			index_array_R = exp.indexOf("]");
			List<Integer> temp_indexList = new ArrayList<Integer>(indexList);
			
			for(int i=0;i<temp_indexList.size();i++){
				//System.out.println(i);
				if((index_array_L>0)&&(temp_indexList.get(0)>index_array_L)){
					if(temp_indexList.get(i) < index_array_R){
						indexList.remove(i);
					}
				}					
			}
			if(indexList.size()>0){
				String firstExpStr = exp.substring(0, indexList.get(0));
				//System.out.println("firstExpStr: "+ firstExpStr);
				String secondExpStr = exp.substring(indexList.get(0)+1);
				//System.out.println("secondExpStr: "+ secondExpStr);
				
				Expressions firstExp;
				Expressions secondExp;
				Opa operators = new Opa();
				String op;				
				firstExp = getSingleExpression(firstExpStr);
				if(isNumeric(secondExpStr)){
					int result = Integer.parseInt(secondExpStr);
					secondExp = new IntegerN(result);
				}else if(isVariable(secondExpStr)){
					secondExp = new VariableX(secondExpStr);					
				}else{
					secondExp = getExpressions(secondExpStr);
				}
				if(exp.charAt(indexList.get(0)) == '+'){
					op = operators.getAdd();
				}else if(exp.charAt(indexList.get(0)) == '-'){
					op = operators.getMin();
				}else if(exp.charAt(indexList.get(0)) == '*'){
					op = operators.getMulti();
				}else{ //if(exp.charAt(indexList.get(0)) == '/'){
					op = operators.getDiv();
				}
				expression = new ExpressionOperations(firstExp,op,secondExp);
			}else{
				expression = getSingleExpression(exp);
			}		
		}else{
			expression = getSingleExpression(exp);
		}								
		return expression;
	}
	
	public boolean isVariable(String basicElement){
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(basicElement);
		if (matcher.matches()) {			
            return true;
	    }else{
	    	return false;
	    }		
	}
			
	public boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	public Expressions getSingleExpression(String exp){
		Expressions singlrExpression = new Expressions();
		if(isNumeric(exp)){
			int n = Integer.parseInt(exp);
			singlrExpression = new IntegerN(n);					
		}else{
			Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
			Matcher matcher = pattern.matcher(exp);
			if (!matcher.matches()) {			
				String varName = exp.substring(0, exp.indexOf("["));
				String arrayIndexStr = foundArrayIndex(exp);
	            //String arrayIndexStr = exp.substring(exp.indexOf("[") + 1, exp.indexOf("]"));	            
	            Expressions arrayIndex = getExpressions(arrayIndexStr);            
	            singlrExpression = new Array(varName,arrayIndex);               
		    }else{			
		    	singlrExpression = new VariableX(exp);				
		    }	
		}
		return singlrExpression;
	}	
}
