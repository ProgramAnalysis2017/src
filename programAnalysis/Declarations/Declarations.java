package programAnalysis.Declarations;
import java.util.*;

public class Declarations {
	//private IntArray intArray;
	//private IntX intX;
	private List<Declarations> declarations = new ArrayList<Declarations>();
	//public Declarations(List<Declarations> declarations) {
	//	this.declarations = declarations;
	//}
	
	public List<Declarations> getDeclarations(){
		return declarations;
	}
	
	public void addDeclarations(Declarations d1) {
		declarations.add(d1);
		//return declarations;
	}
}
