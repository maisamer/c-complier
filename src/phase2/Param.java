package phase2;

import phase1.Lexeme;

public class Param implements Node{
	public Type_spec type_spec;
	public Lexeme id;
	public Bractes bractes;
	public Param(Type_spec type_spec,Lexeme id) {
		// TODO Auto-generated constructor stub
		this.type_spec = type_spec;
		this.id = id;
		this.bractes = null;
		
	}
	public Param(Type_spec type_spec,Lexeme id,Bractes bractes) {
		// TODO Auto-generated constructor stub
		this.type_spec = type_spec;
		this.id = id;
		this.bractes = bractes;
	}

	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("----------param-----------");
		type_spec.printNode();
		System.out.println("--------"+id.token+"----------\n"+id.value);
		if(bractes != null)
			bractes.printNode();		
	}

}
