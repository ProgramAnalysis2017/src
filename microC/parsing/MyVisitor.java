package microC.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import microC.parsing.MicroCParser.DeclContext;
import microC.parsing.MicroCParser.ProgramContext;
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

public class MyVisitor extends MicroCBaseVisitor<Program> {
	
	

	
}



