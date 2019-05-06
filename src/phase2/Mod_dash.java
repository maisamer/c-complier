package phase2;

import phase1.Lexeme;

public class Mod_dash implements Node{
	Lexeme modop;
	Final finl;
	Mod_dash mod_dash;
	public Mod_dash(Lexeme n,Final l,Mod_dash ne) {
		// TODO Auto-generated constructor stub
		this.modop = n;
		this.finl=l;
		this.mod_dash=ne;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(Mod_dash)---------");
		System.out.println("-------"+modop.token+"-------\n"+modop.value);
		finl.printNode();
		if(mod_dash!=null)
			mod_dash.printNode();
		
	}

}
