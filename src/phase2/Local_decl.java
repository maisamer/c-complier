package phase2;

import phase1.Lexeme;

public class Local_decl implements Node{
	
    private Type_spec type_spec;
	private Bractes bractes;
    private Lexeme id ;
    private Lexeme semicolom;
    public Local_decl(Type_spec type_spec,Bractes bractes,Lexeme id,Lexeme semicolom) {
		// TODO Auto-generated constructor stub
    	this.type_spec = type_spec;
    	this.bractes = bractes;
    	this.id = id;
    	this.semicolom = semicolom;
	}
    public Local_decl(Type_spec type_spec,Lexeme id,Lexeme semicolom) {
		// TODO Auto-generated constructor stub
    	this.type_spec = type_spec;
    	this.id = id;
    	this.semicolom = semicolom;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Local_decl-----------");
		type_spec.printNode();
		System.out.println("----------"+id.token+"---------\n "+id.value);
		if(bractes != null) {
			bractes.printNode();
		}
		System.out.println("----------"+semicolom.token+"----------\n"+semicolom.value);	
	}

}
