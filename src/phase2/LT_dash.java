package phase2;

import phase1.Lexeme;

public class LT_dash implements Node{
	Lexeme lthan;
	NE ne;
	LT_dash lt_dash;
	public LT_dash(Lexeme l,NE n,LT_dash lt) {
		// TODO Auto-generated constructor stub
		lthan=l;
		ne=n;
		lt_dash = lt;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(LT_dash)---------");
		System.out.println("-------"+lthan.token+"-------\n"+lthan.value);
		ne.printNode();
		if(lt_dash!=null)
			lt_dash.printNode();
	}

}
