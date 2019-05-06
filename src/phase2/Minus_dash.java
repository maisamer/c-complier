package phase2;

import phase1.Lexeme;

public class Minus_dash implements Node{
	Lexeme minusop;
	Mult mult;
	Minus_dash minus_dash;
	public Minus_dash(Lexeme n,Mult l,Minus_dash ne) {
		// TODO Auto-generated constructor stub
		this.minusop = n;
		this.mult=l;
		this.minus_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Minus_dash)---------");
		System.out.println("-------"+minusop.token+"-------\n"+minusop.value);
		mult.printNode();
		if(minus_dash!=null)
			minus_dash.printNode();
		
	}

}
