package phase2;

import phase1.Lexeme;

public class Bractes implements Node{
	//[]
    private Lexeme leftbracets;
    private Lexeme rightbracets;
	
	public Bractes(Lexeme leftbracets, Lexeme rightbracets) {
		this.leftbracets = leftbracets;
		this.rightbracets = rightbracets;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("----------"+leftbracets.token+"----------\n"+leftbracets.value);
		System.out.println("----------"+rightbracets.token+"----------\n"+rightbracets.value);
	}

}
