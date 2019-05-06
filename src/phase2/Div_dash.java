package phase2;

import phase1.Lexeme;

public class Div_dash implements Node{

	Lexeme divop;
	Mod mod;
	Div_dash div_dash;
	public Div_dash(Lexeme n,Mod l,Div_dash ne) {
		// TODO Auto-generated constructor stub
		this.divop = n;
		this.mod=l;
		this.div_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Div_dash)---------");
		System.out.println("-------"+divop.token+"-------\n"+divop.value);
		mod.printNode();
		if(div_dash!=null)
			div_dash.printNode();
		
	}

}
