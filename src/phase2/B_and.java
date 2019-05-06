package phase2;


public class B_and implements Node{
	GE ge;
	B_and_dash b_and_dash;
	public B_and(GE g,B_and_dash b1) {
		// TODO Auto-generated constructor stub
		ge=g;
		b_and_dash=b1;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------expr(B_and)---------");
		//System.out.println("-------"+id.token+"--------\n"+id.value);
		ge.printNode();
		if(b_and_dash!=null) {
			b_and_dash.printNode();
		}
		
	}
	
}
