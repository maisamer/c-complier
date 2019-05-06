package phase2;

import phase1.Lexeme;

public class Fun_decl implements Node{
	private Type_spec type_spec;
	private Lexeme id;
	private Lexeme left;
	private Params params;
	private Lexeme right;
	private Compound_stmt compound_stmt;
	public Fun_decl(Type_spec type_spec,Lexeme id,Lexeme left,Params params,Lexeme right,Compound_stmt compound_stmt) {
		// TODO Auto-generated constructor stub
		this.type_spec = type_spec;
		this.id = id;
		this.left = left;
		this.right=right;
		this.params=params;
		this.compound_stmt = compound_stmt;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Fun_decl-----------");
		type_spec.printNode();
		System.out.println("----------ID-----------------");
		System.out.println(id.value);
		System.out.println("---------"+ left.token + "-----------\n"+left.value);
		params.printNode();
		System.out.println("---------"+right.token+"---------\n"+right.value);
		compound_stmt.printNode();
		
	}

}
