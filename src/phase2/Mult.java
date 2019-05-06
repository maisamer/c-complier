package phase2;

public class Mult implements Node{	
	Div div;
	Mult_dash mult_dash;
	public Mult(Div e,Mult_dash n) {
		// TODO Auto-generated constructor stub
		this.div=e;
		this.mult_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Mult)---------");
		div.printNode();
		if(mult_dash!=null)
			mult_dash.printNode();
	}

}
