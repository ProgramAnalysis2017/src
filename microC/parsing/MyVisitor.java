package microC.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import microC.parsing.MicroCParser.DeclContext;
import microC.parsing.MicroCParser.StmtContext;
import programAnalysis.Declarations.DeclarationsSeqs;
import programAnalysis.Declarations.IntArray;
import programAnalysis.Declarations.IntX;
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
import programAnalysis.statements.If;
import programAnalysis.statements.IfElse;
import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;

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
	           String typeName = declaration.substring(0,3);
	           String arraySizeStr = declaration.substring(declaration.indexOf("[") + 1, declaration.indexOf("]"));
	           String varName = declaration.substring(3, declaration.indexOf("["));
	           int arraySize = Integer.parseInt(arraySizeStr);
	           IntArray declArray = new IntArray(typeName,varName,arraySize);
	           decs.setIntArray(declArray);
	           System.out.println(typeName+" "+varName+"["+arraySize+"]");
	    }else{    	
	    	String typeName = declaration.substring(0,3);
	    	String varName = declaration.substring(3,declaration.indexOf(";"));
	    	int VarValue = 0;
	    	IntX declVar = new IntX(typeName,varName,VarValue);
	    	decs.setIntX(declVar);
	    	System.out.println(typeName+" "+varName);
	    }
		if( null != ctx.decl()) {
			decs.setD1( visitDecl(ctx.decl()) );
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
		//System.out.println(basicStatement);		
		//basicStatement = "while(not false){if(A[i]+1>=0){readx;writex/y;readAa[2+5];continue;break;intx;intA[3];x=x+A[i];i=i+1;}else{i=i+1;break;}y=y+1;}";
		//basicStatement = "while(not false){if(A[i]+1>=0){x=x+A[i];i=i+1;}y=y+1;}";
		ProcessBasicBlock(basicStatement, statements);
		if( null != ctx.stmt()) {
			statements.setS1( visitStmt(ctx.stmt()) );
		}
//		System.out.println("--------------------------------------------");
//		String test = "y+z";
//		Expressions expression = new Expressions();
//		VariableX x = new VariableX("x");
//		Opa add = new Opa();
//		String op = add.getAdd();
//		IntegerN n = new IntegerN(5);
//		expression = new ExpressionOperations(x,op,n);
//		System.out.println(expression.toString());
//		expression = new ExpressionOperations(n,op,x);
//		System.out.println(expression.toString());
//		Expressions ex = getExpression(test);
//		System.out.println(ex);
		//getExpression(test, statements);
//		System.out.println("--------------------------------------------");
		return statements; 
	}
	
	public void ProcessBasicBlock(String restBlocks, Statements statements){
		if(restBlocks.toLowerCase().startsWith("while")){
			String whileConditionStr = foundCondition(restBlocks);
			String whileBody = foundBody(restBlocks);
			String temp_restBlocks = restBlocks.substring(whileConditionStr.length() + whileBody.length() + 9);
			Expressions whileCondirion = getBoolExpression(whileConditionStr);			
			While whileStatement = new While();
			whileStatement.setB(whileCondirion);
			System.out.println(whileCondirion.toString());
			//System.out.println("While condition: "+whileCondirion.toString());
			//System.out.println("While body: "+whileBody);
			ProcessBasicBlock(whileBody,whileStatement.getS0());
			if (temp_restBlocks.length() > 0){
				ProcessBasicBlock(temp_restBlocks,statements);
			}
			
		}else if(restBlocks.toLowerCase().startsWith("if")){
			String ifConditionStr = foundCondition(restBlocks);
			String s0 = foundBody(restBlocks);
			String temp_restBlocks = restBlocks.substring(ifConditionStr.length() + s0.length() + 6);
			Expressions ifConditon = getBoolExpression(ifConditionStr);
			System.out.println(ifConditon.toString());
			//System.out.println("If condition: "+ifCondition);
			//System.out.println("If body s0: "+s0);
			boolean ifElse = false;
			if((temp_restBlocks.length() > 0) && temp_restBlocks.toLowerCase().startsWith("else")){
				ifElse = true;
			}
			if(!ifElse){
				If ifStatement = new If();
				ifStatement.setExpressions(ifConditon);	
				ProcessBasicBlock(s0,ifStatement.getS0());
				if (temp_restBlocks.length() > 0){
					ProcessBasicBlock(temp_restBlocks,statements);
				}
			}else{
				IfElse ifStatement = new IfElse();
				ifStatement.setExpressions(ifConditon);	
				ProcessBasicBlock(s0,ifStatement.getS1());
				String s2 = foundBody(temp_restBlocks);
				ProcessBasicBlock(s2,ifStatement.getS2());
				String restBlock_AfterS1 = temp_restBlocks.substring(s2.length() + 6);
				if(restBlock_AfterS1.length() > 0){
					ProcessBasicBlock(restBlock_AfterS1,statements);
				}
			}										
		}else if(restBlocks.toLowerCase().startsWith("read")){			
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
			Matcher matcher = pattern.matcher(basicBlock);
			if (!matcher.matches()) {
	            String read = basicBlock.substring(0,4);
	            String arraySizeStr = basicBlock.substring(basicBlock.indexOf("[") + 1, basicBlock.indexOf("]"));
	            String varName = basicBlock.substring(4, basicBlock.indexOf("["));
	            
	            System.out.println(read+" "+varName+"["+arraySizeStr+"]");
		    }else{
				String read = basicBlock.substring(0,4);
				String varName = basicBlock.substring(4);	
				
				System.out.println(read+" "+varName);				
				//System.out.println("rest: "+ rest);
		    }	
			ProcessBasicBlock(rest,statements);					
		}else if(restBlocks.toLowerCase().startsWith("write")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);			
			String write = basicBlock.substring(0,5);
			String varName = basicBlock.substring(5);
			
			System.out.println(write+" "+varName);		
			//System.out.println("rest: "+ rest);
			ProcessBasicBlock(rest,statements);			
		}else if(restBlocks.toLowerCase().startsWith("continue")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			System.out.println(basicBlock);		
			//System.out.println("rest: "+ rest);
			ProcessBasicBlock(rest,statements);		
		}else if(restBlocks.toLowerCase().startsWith("break")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			System.out.println(basicBlock);			
			//System.out.println("rest: "+ rest);
			ProcessBasicBlock(rest,statements);
		}else if(restBlocks.toLowerCase().startsWith("int")){			
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
			Matcher matcher = pattern.matcher(basicBlock);
			if (!matcher.matches()) {
	           String typeName = basicBlock.substring(0,3);
	           String arraySizeStr = basicBlock.substring(basicBlock.indexOf("[") + 1, basicBlock.indexOf("]"));
	           String varName = basicBlock.substring(3, basicBlock.indexOf("["));
	           int arraySize = Integer.parseInt(arraySizeStr);
	           
	           System.out.println(typeName+" "+varName+"["+arraySize+"]");
	           ProcessBasicBlock(rest,statements);
		    }else{    	
		    	String typeName = basicBlock.substring(0,3);
		    	String varName = basicBlock.substring(3);
		    	int VarValue = 0;
		    	
		    	System.out.println(typeName+" "+varName);
		    	ProcessBasicBlock(rest,statements);
		    }
		}else{
			// the rest blocks are assignments
			if(restBlocks.length() > 0){
				String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
				String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
				
				Pattern pattern = Pattern.compile("[a-zA-Z0-9;]*");
				Matcher matcher = pattern.matcher(basicBlock);
				if (!matcher.matches()) {
					String varName = basicBlock.substring(0, restBlocks.indexOf("="));
					String exp = basicBlock.substring(basicBlock.indexOf("=") + 1);
		           
		            System.out.println(varName + "=" + exp);
		            
		            Pattern patternExp = Pattern.compile("[a-zA-Z0-9;]*");
					Matcher matcherExp = patternExp.matcher(exp);
					if(!matcherExp.matches()){
						int index_add = 0;
						int index_sub = 0;
						int index_mul = 0;
						int index_div = 0;
						if(exp.indexOf("+")>0){
							index_add = exp.indexOf("+");
							String firstVar = exp.substring(0, exp.indexOf("+"));
							String secondVar = exp.substring(exp.indexOf("+")+1);
						}
						if(exp.indexOf("-")>0){
							index_sub = exp.indexOf("-");
							String firstVar = exp.substring(0, exp.indexOf("-"));
							String secondVar = exp.substring(exp.indexOf("-")+1);
						}
						if(exp.indexOf("*")>0){
							index_mul = exp.indexOf("*");
							String firstVar = exp.substring(0, exp.indexOf("*"));
							String secondVar = exp.substring(exp.indexOf("*")+1);
						}
						if(exp.indexOf("/")>0){
							index_div = exp.indexOf("/");
							String firstVar = exp.substring(0, exp.indexOf("/"));
							String secondVar = exp.substring(exp.indexOf("/")+1);
						}

					}else{
						
					}
		          
			    }
				ProcessBasicBlock(rest,statements);
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
			//statements.setExpreOp(expOpr);
			//System.out.println(firstExpStr+op_bool+secondExpStr);
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
			//statements.setExpreOp(expOpr);
			//System.out.println(firstExpStr+op_bool+secondExpStr);
		}else if(boolExp.toLowerCase().startsWith("not")){
			String not = boolExp.substring(0,3);
			String exp = boolExp.substring(3);
			if((exp.indexOf("(")>=0) || (exp.indexOf(")")>=0)){
				exp = exp.substring(exp.indexOf("(") + 1,exp.indexOf(")"));
			}
			Expressions expObj = getExpression(exp);
			expression = new NotB(not,expObj);
			//statements.setNotB(notB);
			//System.out.println(notB.getNon()+exp);
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
				//statements.setExpreOp(expOpr);
				//System.out.println(firstExpStr+op_lessEquals+secondExpStr);
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
				//statements.setExpreOp(expOpr);
				//System.out.println(firstExpStr+op_greatEuqals+secondExpStr);
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
				//statements.setExpreOp(expOpr);
				//System.out.println(firstExpStr+op_notEquals+secondExpStr);
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
				//statements.setExpreOp(expOpr);
				//System.out.println(firstExpStr+op_lessThan+secondExpStr);
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
				//statements.setExpreOp(expOpr);
				//System.out.println(firstExpStr+op_greatThan+secondExpStr);
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
//				statements.setExpreOp(expOpr);
//				System.out.println(firstExpStr+op_equals+secondExpStr);
			}else if(boolExp.toLowerCase().startsWith("true")){
				expression = new True();		
				//statements.setTrue_t(trueExp);
				//System.out.println(trueExp.getIsTrue());
			}else if(boolExp.toLowerCase().startsWith("false")){
				expression = new False();
//				statements.setFalse_f(falseExp);
//				System.out.println(falseExp.getIsFalse());
			}				
		}
		return expression;
	}
	public Expressions getExpression(String exp){
		Expressions expression = new Expressions();
		if(exp.indexOf("+")>=0){
			String firstExpStr = exp.substring(0, exp.indexOf("+"));
			String secondExpStr = exp.substring(exp.indexOf("+")+1);
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
			Opa op = new Opa();
			String op_add = op.getAdd();
			expression = new ExpressionOperations(firstExp,op_add,secondExp);
			//statements.setExpreOp(expOpra);
			//System.out.println(firstExpStr+" "+op_add+" "+secondExpStr);
			//return expOpra;
		}else if(exp.indexOf("-")>=0){
			String firstExpStr = exp.substring(0, exp.indexOf("-"));
			String secondExpStr = exp.substring(exp.indexOf("-")+1);
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
			Opa op = new Opa();
			String op_sub = op.getMin();
			expression = new ExpressionOperations(firstExp,op_sub,secondExp);
			//statements.setExpreOp(expOpra);
			//System.out.println(firstExpStr+" "+op_sub+" "+secondExpStr);
			//return expOpra;
		}else if(exp.indexOf("*")>=0){
			String firstExpStr = exp.substring(0, exp.indexOf("*"));
			String secondExpStr = exp.substring(exp.indexOf("*")+1);
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
			Opa op = new Opa();
			String op_multi = op.getMulti();
			expression = new ExpressionOperations(firstExp,op_multi,secondExp);
			//statements.setExpreOp(expOpra);
			//System.out.println(firstExpStr+" "+op_multi+" "+secondExpStr);
			//return expOpra;
		}else if(exp.indexOf("/")>=0){			
			String firstExpStr = exp.substring(0, exp.indexOf("/"));
			String secondExpStr = exp.substring(exp.indexOf("/")+1);
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
			Opa op = new Opa();
			String op_div = op.getDiv();
			expression = new ExpressionOperations(firstExp,op_div,secondExp);
			//statements.setExpreOp(expOpra);
			//System.out.println(firstExpStr+" "+op_div+" "+secondExpStr);
			//return expOpra;
		}
		return expression;
	}
	
	public boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
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
