package phase2;

public class Expr implements Node{
	B_or b;
	public Expr(B_or b1) {
		// TODO Auto-generated constructor stub
		b=b1;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------just_expr------------");
		b.printNode();
	}

}
