package microC.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import microC.parsing.MicroCParser.DeclContext;
import microC.parsing.MicroCParser.StmtContext;
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
		DeclarationsSeqs decs = new DeclarationsSeqs();
		String declaration = ctx.basicDecl().getText();//get the first statement of a list of statement;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
		Matcher matcher = pattern.matcher(declaration);
		if (!matcher.matches()) {
	           //String typeName = declaration.substring(0,3);
	           String arraySizeStr = declaration.substring(declaration.indexOf("[") + 1, declaration.indexOf("]"));
	           String varName = declaration.substring(3, declaration.indexOf("["));
	           int arraySize = Integer.parseInt(arraySizeStr);
	           IntArray declArray = new IntArray(varName,arraySize);
	           decs.setD1(declArray);
	           
	           System.out.println(declArray.toString());
	    }else{    	
	    	//String typeName = declaration.substring(0,3);
	    	String varName = declaration.substring(3,declaration.indexOf(";"));
	    	IntX declVar = new IntX(varName);
	    	decs.setD1(declVar);
	    	System.out.println(declVar.toString());
	    }
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
	@Override public T visitBasicStmt(MicroCParser.BasicStmtContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public StatementsSeqs visitStmt(MicroCParser.StmtContext ctx) { 
		StatementsSeqs statements = new StatementsSeqs();
		String basicStatement = ctx.basicStmt().getText();
		ProcessBasicBlock(basicStatement, statements);
		if( null != ctx.stmt()) {
			statements.setS1( visitStmt(ctx.stmt()));
		}		
		return statements; 
	}
	
	public void ProcessBasicBlock(String restBlocks, StatementsSeqs statements){
		if(restBlocks.toLowerCase().startsWith("while")){
			System.out.println("While");
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			
			String whileConditionStr = foundCondition(restBlocks);
			String whileBody = foundBody(restBlocks);
			String restBlocks_afterWhile = restBlocks.substring(whileConditionStr.length() + whileBody.length() + 9);
			
			Expressions whileCondirion = getBoolExpression(whileConditionStr);			
			While whileStatement = new While();
			whileStatement.setB(whileCondirion);
			
			System.out.println(whileCondirion.toString());
			ProcessBasicBlock(whileBody,whileStatement.getS0());
		
			statementsSeqs.setS1(whileStatement);
			if (restBlocks_afterWhile.length() > 0){
				ProcessBasicBlock(restBlocks_afterWhile,statements.getS2());
			}
			System.out.println("end");
		}else if(restBlocks.toLowerCase().startsWith("if")){
			System.out.println("if");
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			String ifConditionStr = foundCondition(restBlocks);
			String s0 = foundBody(restBlocks);
			String restBlocks_afters0 = restBlocks.substring(ifConditionStr.length() + s0.length() + 6);
			Expressions ifConditon = getBoolExpression(ifConditionStr);
			System.out.println(ifConditon.toString());
			
			boolean ifElse = false;
			if((restBlocks_afters0.length() > 0) && restBlocks_afters0.toLowerCase().startsWith("else")){
				ifElse = true;
			}
			if(!ifElse){
				If ifStatement = new If();
				ifStatement.setB(ifConditon);
				ProcessBasicBlock(s0,ifStatement.getS0());
				statementsSeqs.setS1(ifStatement);
				System.out.println("end if");
				if (restBlocks_afters0.length() > 0){
					ProcessBasicBlock(restBlocks_afters0,statementsSeqs.getS2());
				}
			}else{
				IfElse ifStatement = new IfElse();
				ifStatement.setB(ifConditon);	
				ProcessBasicBlock(s0,ifStatement.getS1());
				String s2 = foundBody(restBlocks_afters0);
				System.out.println("else");
				ProcessBasicBlock(s2,ifStatement.getS2());
				statementsSeqs.setS1(ifStatement);
				String restBlock_AfterS2 = restBlocks_afters0.substring(s2.length() + 6);
				System.out.println("end if");
				if(restBlock_AfterS2.length() > 0){
					ProcessBasicBlock(restBlock_AfterS2,ifStatement.getS2());
				}
				
			}										
		}else if(restBlocks.toLowerCase().startsWith("read")){			
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
			Matcher matcher = pattern.matcher(basicBlock);
			if (!matcher.matches()) {
	            //String read = basicBlock.substring(0,4);
	            String arrayIndexStr = basicBlock.substring(basicBlock.indexOf("[") + 1, basicBlock.indexOf("]"));
	            String varName = basicBlock.substring(4, basicBlock.indexOf("["));
	            
	            Expressions arrayIndex = getExpressions(arrayIndexStr);
	            ReadArray readArray = new ReadArray(varName,arrayIndex);    
	            StatementsSeqs statementsSeqs = new StatementsSeqs();
				statements = statementsSeqs;
				statementsSeqs.setS1(readArray);
	            System.out.println(readArray.toString());
	            ProcessBasicBlock(rest,statementsSeqs.getS2());
		    }else{
				//String read = basicBlock.substring(0,4);
				String varName = basicBlock.substring(4);				
				ReadX readX = new ReadX(varName);						
				StatementsSeqs statementsSeqs = new StatementsSeqs();
				statements = statementsSeqs;
				statementsSeqs.setS1(readX);
				System.out.println(readX.toString());				
				ProcessBasicBlock(rest,statementsSeqs.getS2());
		    }	
								
		}else if(restBlocks.toLowerCase().startsWith("write")){
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);			
			//String write = basicBlock.substring(0,5);
			String expStr = basicBlock.substring(5);
			Expressions exp = getExpressions(expStr);			
			Write writeExp = new Write(exp);
			statementsSeqs.setS1(writeExp);		
			System.out.println(writeExp.toString());
			ProcessBasicBlock(rest,statementsSeqs.getS2());			
		}else if(restBlocks.toLowerCase().startsWith("continue")){
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			//String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			Continue con = new Continue();
			statementsSeqs.setS1(con);
			System.out.println(con.toString());	
			ProcessBasicBlock(rest,statementsSeqs.getS2());		
		}else if(restBlocks.toLowerCase().startsWith("break")){
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			//String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			Break bre = new Break();
			statementsSeqs.setS1(bre);
			System.out.println(bre.toString());			
			ProcessBasicBlock(rest,statementsSeqs.getS2());
		}else if(restBlocks.toLowerCase().startsWith("int")){		// need to update	
			StatementsSeqs statementsSeqs = new StatementsSeqs();
			statements = statementsSeqs;
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
			Matcher matcher = pattern.matcher(basicBlock);
			if (!matcher.matches()) {
	           //String typeName = basicBlock.substring(0,3);
	           String arraySizeStr = basicBlock.substring(basicBlock.indexOf("[") + 1, basicBlock.indexOf("]"));
	           String varName = basicBlock.substring(3, basicBlock.indexOf("["));
	           int arraySize = Integer.parseInt(arraySizeStr);
	           
	           IntArray intArray = new IntArray(varName,arraySize);
	           statementsSeqs.setS1(intArray);
	           
	           System.out.println(intArray.toString());
	           ProcessBasicBlock(rest,statementsSeqs.getS2());
		    }else{    	
		    	//String typeName = basicBlock.substring(0,3);
		    	String varName = basicBlock.substring(3);
		    	
		    	IntX intX = new IntX(varName);
		    	statementsSeqs.setS1(intX);
		    	System.out.println(intX.toString());
		    	ProcessBasicBlock(rest,statementsSeqs.getS2());
		    }
		}else{
			// the rest blocks are assignments
			if(restBlocks.length() > 0){
				StatementsSeqs statementsSeqs = new StatementsSeqs();
				statements = statementsSeqs;
				
				String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
				String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
				
				Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
				Matcher matcher = pattern.matcher(basicBlock);
				if (!matcher.matches()) {
					String leftSideStr = basicBlock.substring(0, restBlocks.indexOf("="));
					String rightSideStr = basicBlock.substring(basicBlock.indexOf("=") + 1);				
					Expressions exp = getExpressions(rightSideStr);				
					Matcher localMatcher = pattern.matcher(leftSideStr);
					if (!localMatcher.matches()) {			
						String arrayName = leftSideStr.substring(0, leftSideStr.indexOf("["));
			            String arrayIndexStr = leftSideStr.substring(leftSideStr.indexOf("[") + 1, leftSideStr.indexOf("]"));	            
			            Expressions arrayIndex = getExpressions(arrayIndexStr);            
			            AssignmentArray assArray = new AssignmentArray(arrayName,arrayIndex,arrayIndex); 
			            statementsSeqs.setS1(assArray);
			            System.out.println(assArray.toString());
			            
				    }else{			
				    	Assignment assVar = new Assignment(leftSideStr,exp);	
				    	statementsSeqs.setS1(assVar);
				    	System.out.println(assVar.toString());
				    }
					ProcessBasicBlock(rest,statementsSeqs.getS2());
				}		
			}
		}
	}
	
	public String foundBody(String body){
		String temp_body = body;
		List<Integer> indexsLeft = new ArrayList<Integer>();
		List<Integer> indexsRight = new ArrayList<Integer>();
		boolean foundBody = true;
		boolean firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf("{")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsLeft.add(temp_body.indexOf("{"));
				}else{
					indexsLeft.add(temp_body.indexOf("{")+indexsLeft.get(indexsLeft.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf("{") + 1);
			}else{
				foundBody = false;
			} 
		}
		temp_body = body;
		foundBody = true;
		firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf("}")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsRight.add(temp_body.indexOf("}"));
				}else{
					indexsRight.add(temp_body.indexOf("}")+indexsRight.get(indexsRight.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf("}") + 1);
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
	
	public String foundCondition(String body){
		String temp_body = body;
		List<Integer> indexsLeft = new ArrayList<Integer>();
		List<Integer> indexsRight = new ArrayList<Integer>();
		boolean foundBody = true;
		boolean firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf("(")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsLeft.add(temp_body.indexOf("("));
				}else{
					indexsLeft.add(temp_body.indexOf("(")+indexsLeft.get(indexsLeft.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf("(") + 1);
			}else{
				foundBody = false;
			} 
		}
		temp_body = body;
		foundBody = true;
		firstEntry = true;
		while(foundBody){
			if(temp_body.indexOf(")")>=0){
				if(firstEntry){
					firstEntry = false;
					indexsRight.add(temp_body.indexOf(")"));
				}else{
					indexsRight.add(temp_body.indexOf(")")+indexsRight.get(indexsRight.size()-1)+1);
				}				
				temp_body = temp_body.substring(temp_body.indexOf(")") + 1);
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
		
//	public Expressions getExpression(String exp){
//		Expressions expression = new Expressions();
//		if(exp.indexOf("+")>=0){
//			String firstExpStr = exp.substring(0, exp.indexOf("+"));
//			String secondExpStr = exp.substring(exp.indexOf("+")+1);
//			Expressions firstExp;
//			Expressions secondExp;
//			
//			firstExp = getSingleExpression(firstExpStr);
//			secondExp = getSingleExpression(secondExpStr);
//			
//			Opa op = new Opa();
//			String op_add = op.getAdd();
//			expression = new ExpressionOperations(firstExp,op_add,secondExp);
//		}else if(exp.indexOf("-")>=0){
//			String firstExpStr = exp.substring(0, exp.indexOf("-"));
//			String secondExpStr = exp.substring(exp.indexOf("-")+1);
//			Expressions firstExp;
//			Expressions secondExp;
//						
//			firstExp = getSingleExpression(firstExpStr);
//			secondExp = getSingleExpression(secondExpStr);
//			
//			Opa op = new Opa();
//			String op_sub = op.getMin();
//			expression = new ExpressionOperations(firstExp,op_sub,secondExp);
//
//		}else if(exp.indexOf("*")>=0){
//			String firstExpStr = exp.substring(0, exp.indexOf("*"));
//			String secondExpStr = exp.substring(exp.indexOf("*")+1);
//			Expressions firstExp;
//			Expressions secondExp;
//			
//			firstExp = getSingleExpression(firstExpStr);
//			secondExp = getSingleExpression(secondExpStr);
//			
//			Opa op = new Opa();
//			String op_multi = op.getMulti();
//			expression = new ExpressionOperations(firstExp,op_multi,secondExp);
//
//		}else if(exp.indexOf("/")>=0){			
//			String firstExpStr = exp.substring(0, exp.indexOf("/"));
//			String secondExpStr = exp.substring(exp.indexOf("/")+1);
//			Expressions firstExp;
//			Expressions secondExp;
//			
//			firstExp = getSingleExpression(firstExpStr);
//			secondExp = getSingleExpression(secondExpStr);
//			Opa op = new Opa();
//			String op_div = op.getDiv();
//			expression = new ExpressionOperations(firstExp,op_div,secondExp);		
//		}else{
//			expression = getSingleExpression(exp);
//		}
//		return expression;
//	}
	
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
	@Override public T visitInteger(MicroCParser.IntegerContext ctx) { return visitChildren(ctx); }
	
}
