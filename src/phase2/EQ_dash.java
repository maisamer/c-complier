package phase2;

import phase1.Lexeme;

public class EQ_dash implements Node{
	Lexeme eq;
	Plus plus;
	EQ_dash eq_dash;
	public EQ_dash(Lexeme n,Plus l,EQ_dash ne) {
		// TODO Auto-generated constructor stub
		this.eq = n;
		this.plus=l;
		this.eq_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(EQ_dash)---------");
		System.out.println("-------"+eq.token+"-------\n"+eq.value);
		plus.printNode();
		if(eq_dash!=null)
			eq_dash.printNode();
		
	}

}
