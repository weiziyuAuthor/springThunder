package yu.interpreter;

public class ProgramNode extends Node {
	private Node commandListNode;
	public void parse(Context context) throws ParseException{
		
	}
	
	public String toString(){
		return "[program "+commandListNode+"]";
	}
}
