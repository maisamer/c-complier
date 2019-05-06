package phase2;

public class B_or implements Node{
	private B_and b_and ;
	private B_or_dash b_or_dash;
	public B_or(B_and b1,B_or_dash bs1) {
		// TODO Auto-generated constructor stub
		b_and =b1;
		b_or_dash=bs1;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------expr(B_or)---------");
		b_and.printNode();
		if(b_or_dash!=null)
			b_or_dash.printNode();
		
	}

}
