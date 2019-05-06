package phase2;

import phase1.Lexeme;

public class Arg_list_dash implements Node{
	Lexeme coma;
	Expr e;
	Arg_list_dash a;
	public Arg_list_dash(Lexeme c,Expr e,Arg_list_dash a) {
		// TODO Auto-generated constructor stub
		coma=c;
		this.e=e;
		this.a=a;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("------Args------");
		System.out.println("------"+coma.token+"------\n"+coma.value);
		e.printNode();
		if(a != null)
			a.printNode();
	}

}
