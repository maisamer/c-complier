package phase2;

import phase1.Lexeme;

public class Type_spec implements Node {
	private Lexeme type;
	public Type_spec(Lexeme type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------type_spec------------");
		System.out.println("-----------"+type.token + "-----------\n" + type.value);
		
	}

}
