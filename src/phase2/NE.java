package phase2;

public class NE implements Node{
	EQ eq;
	NE_dash ne_dash;
	public NE(EQ e,NE_dash n) {
		// TODO Auto-generated constructor stub
		this.eq=e;
		this.ne_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(NE)---------");
		eq.printNode();
		if(ne_dash!=null)
			ne_dash.printNode();
	}

}
