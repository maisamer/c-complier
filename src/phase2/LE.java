package phase2;

public class LE implements Node{
	GT gt;
	LE_dash le_dash;
	public LE(GT g,LE_dash le) {
		// TODO Auto-generated constructor stub
		this.gt=g;
		this.le_dash = le;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(LE)---------");
		gt.printNode();
		if(le_dash!=null)
			le_dash.printNode();
	}

}
