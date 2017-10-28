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
        MicroCLexer lex = new MicroCLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        MicroCParser parser = new MicroCParser(tokens);
		ProgramContext ctx = parser.program(); //This command parses the program.
		MicroCVisitor<T> myVisitor = new MyVisitor<T>();
		Program program = myVisitor.visitProgram(ctx);
       
	}
}
