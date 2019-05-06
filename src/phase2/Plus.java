package phase2;

public class Plus implements Node{

	Minus minus;
	Plus_dash plus_dash;
	public Plus(Minus e,Plus_dash n) {
		// TODO Auto-generated constructor stub
		this.minus=e;
		this.plus_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Plus)---------");
		minus.printNode();
		if(plus_dash!=null)
			plus_dash.printNode();
	}

}
