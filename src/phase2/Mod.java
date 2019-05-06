package phase2;

public class Mod implements Node{

	Final finl;
	Mod_dash mod_dash;
	public Mod(Final e,Mod_dash n) {
		// TODO Auto-generated constructor stub
		this.finl=e;
		this.mod_dash=n;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Mod)---------");
		finl.printNode();
		if(mod_dash!=null)
			mod_dash.printNode();
	}

}
