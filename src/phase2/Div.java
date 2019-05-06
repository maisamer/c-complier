package phase2;

public class Div implements Node{
 
	Mod mod;
	Div_dash div_dash;
	public Div(Mod e,Div_dash n) {
		// TODO Auto-generated constructor stub
		this.mod=e;
		this.div_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Div)---------");
		mod.printNode();
		if(div_dash!=null)
			div_dash.printNode();
	}

}
