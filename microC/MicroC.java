package microC;

import java.util.ArrayList;
import java.util.Map;

import org.antlr.v4.runtime.*;
import microC.parsing.*;
import microC.parsing.MicroCParser.ProgramContext;
import programAnalysis.SignDetection.SignDetection;
import programAnalysis.graphs.Gen;
import programAnalysis.graphs.Graph;
import programAnalysis.graphs.Kill;
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
		MicroCVisitor<Program> programVisitor = new ProgramVisitor();
		Program program = programVisitor.visitProgram(ctx);
		
		//Reaching Definition
		Graph g = new Graph();
		System.out.println("------------Test Reaching Definition--------------------");
		g.initData(program);
		System.out.println("------------Test Data List--------------------");
		System.out.println(g.getData());
		System.out.println("----------------------------------------------");
		System.out.println(g.getLabels());
		System.out.println(g.getFlows());
		
		g.initKG();
		System.out.println("--------------------KILL---------------------------------");
		for(Map.Entry<Integer, ArrayList<Kill>> entry : g.getKill().entrySet()  ) {
			System.out.println(entry.getKey() + "   | " + entry.getValue());
		}
		
		System.out.println("--------------------Gen---------------------------------");
		for(Map.Entry<Integer, ArrayList<Gen>> entry : g.getGen().entrySet()  ) {
			System.out.println(entry.getKey() + "   | " + entry.getValue());
		}
		System.out.println();
		
		g.algorithmMatrix();
		System.out.println();
		int rdo = 0;
		for(ArrayList<String> list : g.getRDo()) {
			rdo ++;
			System.out.println("RDo("+rdo+")  | "+list);
		}
		
		System.out.println();
		int rdexit = 0;
		for(ArrayList<String> list : g.getRDexit()) {
			rdexit ++;
			System.out.println("RD.("+rdexit+")  | "+list);
		}
		
		//Detection of Sign
		System.out.println();
		System.out.println("------------Test Detection of Sign--------------------");
		SignDetection sd = new SignDetection(program);
		sd.initData();
		System.out.println();
		
	}
}
