package phase2;

import phase1.Lexeme;

public class GT_dash implements Node{
	Lexeme gthan;
	LT lt;
	GT_dash gt_dash;
	public GT_dash(Lexeme g,LT l,GT_dash gt) {
		// TODO Auto-generated constructor stub
		gthan =g;
		lt=l;
		gt_dash = gt;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(GE_dash)---------");
		System.out.println("-------"+gthan.token+"-------\n"+gthan.value);
		lt.printNode();
		if(gt_dash!=null)
			gt_dash.printNode();
	}

}
