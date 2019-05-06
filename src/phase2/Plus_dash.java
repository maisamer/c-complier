package phase2;

import phase1.Lexeme;

public class Plus_dash implements Node{

	Lexeme plus;
	Minus minus;
	Plus_dash plus_dash;
	public Plus_dash(Lexeme n,Minus l,Plus_dash ne) {
		// TODO Auto-generated constructor stub
		this.plus = n;
		this.minus=l;
		this.plus_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(NE_dash)---------");
		System.out.println("-------"+plus.token+"-------\n"+plus.value);
		minus.printNode();
		if(plus_dash!=null)
			plus_dash.printNode();
		
	}
}
