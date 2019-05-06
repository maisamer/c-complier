package phase2;

public class EQ implements Node{

	Plus plus;
	EQ_dash eq_dash;
	public EQ(Plus e,EQ_dash n) {
		// TODO Auto-generated constructor stub
		this.plus=e;
		this.eq_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(EQ)---------");
		plus.printNode();
		if(eq_dash!=null)
			eq_dash.printNode();
	}

}
