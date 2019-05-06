package phase2;

public class Minus implements Node{

	Mult mult;
	Minus_dash minus_dash;
	public Minus(Mult e,Minus_dash n) {
		// TODO Auto-generated constructor stub
		this.mult=e;
		this.minus_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Minus)---------");
		mult.printNode();
		if(minus_dash!=null)
			minus_dash.printNode();
	}

}
