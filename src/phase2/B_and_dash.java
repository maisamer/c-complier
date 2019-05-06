package phase2;

import phase1.Lexeme;

public class B_and_dash implements Node{
	Lexeme and;
	GE ge;
	B_and_dash b_and_dash;
	
	public B_and_dash(Lexeme and2, GE g, B_and_dash b) {
		// TODO Auto-generated constructor stub
		and=and2;
		ge=g;
		b_and_dash=b;
	}

	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------expr(B_and_dash)---------");
		System.out.println("-------"+and.token+"-------\n"+and.value);
		ge.printNode();
		if(b_and_dash!=null) {
			b_and_dash.printNode();
		}
		
	}

}
