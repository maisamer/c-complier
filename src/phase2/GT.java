package phase2;

public class GT implements Node{
	LT lt;
	GT_dash gt_dash;
	public GT(LT l,GT_dash g) {
		// TODO Auto-generated constructor stub
		lt=l;
		gt_dash=g;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(GT)---------");
		lt.printNode();
		if(gt_dash!=null)
			gt_dash.printNode();
	}

}
