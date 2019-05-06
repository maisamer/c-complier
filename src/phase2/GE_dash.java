package phase2;

import phase1.Lexeme;

public class GE_dash implements Node{
	Lexeme gthan;
	LE le;
	GE_dash ge_dash;
	public GE_dash(Lexeme op, LE le2, GE_dash ge) {
		// TODO Auto-generated constructor stub
		this.gthan=op;
		this.le=le2;
		this.ge_dash=ge;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(GE_dash)---------");
		System.out.println("-------"+gthan.token+"-------\n"+gthan.value);
		le.printNode();
		if(ge_dash!=null)
			ge_dash.printNode();
		
	}

}
