package phase2;

import phase1.Lexeme;

public class LE_dash implements Node{
	Lexeme lessEQ;
	GT gt;
	LE_dash le_dash;
	public LE_dash(Lexeme l,GT g,LE_dash le) {
		// TODO Auto-generated constructor stub
		lessEQ = l;
		gt=g;
		le_dash =le;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(LE_dash)---------");
		System.out.println("-------"+lessEQ.token+"-------\n"+lessEQ.value);
		gt.printNode();
		if(le_dash!=null)
			le_dash.printNode();
	}

}
