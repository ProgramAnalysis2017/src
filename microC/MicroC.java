package microC;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import microC.parsing.*;
import microC.parsing.MicroCParser.ProgramContext;
import programAnalysis.graphs.Graph;
import programAnalysis.programs.Program;
import programAnalysis.statements.Statements;
import programAnalysis.statements.StatementsSeqs;
import programAnalysis.statements.While;


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
		While w = new While();
		StatementsSeqs s = new StatementsSeqs();
		s.setS1(w);
		Program p = new Program();
		p.setStatements(s);
		System.out.println(" ????? " + ((StatementsSeqs)p.getStatements()).getS1() );
		Graph g = new Graph();
		g.initData(program);
		System.out.println("------------Test Data List--------------------");
		System.out.println(g.getData());
		System.out.println("----------------------------------------------");
       
	}
}
