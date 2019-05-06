package phase2;

public class GE implements Node{
	LE le;
	GE_dash ge_dash;
	public GE(LE l,GE_dash g) {
		// TODO Auto-generated constructor stub
		le=l;
		ge_dash=g;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(GE)---------");
		le.printNode();
		if(ge_dash!=null)
			ge_dash.printNode();
		
	}

}
