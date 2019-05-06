package phase2;

import phase1.Lexeme;

public class Mult_dash implements Node{

	Lexeme multop;
	Div div;
	Mult_dash mult_dash;
	public Mult_dash(Lexeme n,Div l,Mult_dash ne) {
		// TODO Auto-generated constructor stub
		this.multop = n;
		this.div=l;
		this.mult_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Mult_dash)---------");
		System.out.println("-------"+multop.token+"-------\n"+multop.value);
		div.printNode();
		if(mult_dash!=null)
			mult_dash.printNode();
		
	}

}
