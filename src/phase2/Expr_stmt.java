package phase2;

import phase1.Lexeme;

public class Expr_stmt implements Node{
	private Expr expr;
	private Lexeme semi;
	public Expr_stmt(Expr expr,Lexeme semi) {
		// TODO Auto-generated constructor stub
		this.expr=expr;
		this.semi=semi;
	}
	public Expr_stmt(Lexeme semi) {
		// TODO Auto-generated constructor stub
		this.expr=null;
		this.semi=semi;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------expr_stmt-----------");
		if(expr != null)
			expr.printNode();
		System.out.println("---------"+semi.token+"---------\n"+semi.value);
		
	}

}
