package phase2;

import phase1.Lexeme;

public class B_or_dash implements Node{
	private Lexeme or ;
	private B_and b_and;
	private B_or_dash b_or_dash;
	public B_or_dash(Lexeme or1,B_and b1,B_or_dash bs1) {
		// TODO Auto-generated constructor stub
		or=or1;
		b_and=b1;
		b_or_dash=bs1;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------expr(B_or_dash)---------");
		System.out.println("-------"+or.token+"--------\n"+or.value);
		b_and.printNode();
		if(b_or_dash!=null)
			b_or_dash.printNode();
	}

}
