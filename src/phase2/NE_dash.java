package phase2;

import phase1.Lexeme;

public class NE_dash implements Node{
	Lexeme notEq;
	EQ eq;
	NE_dash ne_dash;
	public NE_dash(Lexeme n,EQ l,NE_dash ne) {
		// TODO Auto-generated constructor stub
		this.notEq = n;
		this.eq=l;
		this.ne_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(NE_dash)---------");
		System.out.println("-------"+notEq.token+"-------\n"+notEq.value);
		eq.printNode();
		if(ne_dash!=null)
			ne_dash.printNode();
		
	}

}
