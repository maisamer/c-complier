package phase2;

import phase1.Lexeme;

public class Break_stmt implements Node{
	//break ;
	private Lexeme brk;
	private Lexeme semi;
	public Break_stmt(Lexeme brk,Lexeme semi) {
		// TODO Auto-generated constructor stub
		this.brk=brk;
		this.semi=semi;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------break_stmt-----------");
		System.out.println("---------"+brk.token+"---------\n"+brk.value);
		System.out.println("---------"+semi.token+"---------\n"+semi.value);
	}

}
