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
		getBasicBlock(basicStatement);
		if( null != ctx.stmt()) {
			statements.setS1( visitStmt(ctx.stmt()) );
		}
		return statements; 
	}
	
	public void getBasicBlock(String restBlocks){
		if(restBlocks.toLowerCase().startsWith("while")){
			String condition = restBlocks.substring(restBlocks.indexOf("(") + 1, restBlocks.indexOf(")"));
			String whileBody = foundBody(restBlocks);		
			System.out.println("While condition: "+condition);
			System.out.println("While body: "+whileBody);
			getBasicBlock(whileBody);
		}else if(restBlocks.toLowerCase().startsWith("if")){
			String ifCondition = restBlocks.substring(restBlocks.indexOf("(") + 1, restBlocks.indexOf(")"));
			String s0 = foundBody(restBlocks);
			System.out.println("If condition: "+ifCondition);
			System.out.println("If body s0: "+s0);
			getBasicBlock(s0);
			String temp_restBlocks = restBlocks.substring(ifCondition.length() + s0.length() + 6);
			if(temp_restBlocks.length() > 0){
				if(temp_restBlocks.toLowerCase().startsWith("else")){
					String s1 = foundBody(temp_restBlocks);
					System.out.println("If body s1: "+ s1);
					getBasicBlock(s1);	
					String restBlock_AfterS1 = temp_restBlocks.substring(s1.length() + 6);
					getBasicBlock(restBlock_AfterS1);
				}else{
					getBasicBlock(temp_restBlocks);
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
			getBasicBlock(rest);					
		}else if(restBlocks.toLowerCase().startsWith("write")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);			
			String write = basicBlock.substring(0,5);
			String varName = basicBlock.substring(5);
			
			System.out.println(write+" "+varName);		
			//System.out.println("rest: "+ rest);
			getBasicBlock(rest);			
		}else if(restBlocks.toLowerCase().startsWith("continue")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			System.out.println(basicBlock);		
			//System.out.println("rest: "+ rest);
			getBasicBlock(rest);		
		}else if(restBlocks.toLowerCase().startsWith("break")){
			String basicBlock = restBlocks.substring(0, restBlocks.indexOf(";"));
			String rest = restBlocks.substring(restBlocks.indexOf(";")+1);
			
			System.out.println(basicBlock);			
			//System.out.println("rest: "+ rest);
			getBasicBlock(rest);
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
	           getBasicBlock(rest);
		    }else{    	
		    	String typeName = basicBlock.substring(0,3);
		    	String varName = basicBlock.substring(3);
		    	int VarValue = 0;
		    	
		    	System.out.println(typeName+" "+varName);
		    	getBasicBlock(rest);
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
				getBasicBlock(rest);
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
