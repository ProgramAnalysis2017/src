package microC;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import microC.parsing.*;
import microC.parsing.MicroCParser.ProgramContext;
import programAnalysis.programs.Program;


public class MicroC {

	public static <T> void main(String args[]) throws Exception {
		if (args.length == 0) {
			System.out.println("Error: No program specified.");
			return;
		}
        MicroCLexer lex = new MicroCLexer(new ANTLRFileStream(args[0]));//save ANTLRFfile input as MicroC lexer
        CommonTokenStream tokens = new CommonTokenStream(lex);			//tokenize the lexer
        MicroCParser parser = new MicroCParser(tokens);					//save the token as MIcroC parser
		ProgramContext ctx = parser.program(); 							//This command parses the program.
		MicroCVisitor<T> myVisitor = new MyVisitor<T>();				//create child object to invoke MicroC parser function
		Program program = myVisitor.visitProgram(ctx);					//create program object of the MicroC P
       
	}
}
