package phase2;

import phase1.Lexeme;

public class While_stmt implements Node{
	//WHILE ( expr ) stmt
	private Lexeme whle;
	private Lexeme left;
	private Expr expr;
	private Lexeme right;
	private Stmt stmt;
	
	public While_stmt(Lexeme whle,Lexeme left,Expr expr,Lexeme right,Stmt stmt) {
		// TODO Auto-generated constructor stub
		this.whle=whle;
		this.left=left;
		this.right=right;
		this.expr=expr;
		this.stmt=stmt;
	}
	
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------while_stmt-----------");
		System.out.println("---------"+whle.token+"---------\n"+whle.value);
		System.out.println("---------"+left.token+"---------\n"+left.value);
		expr.printNode();
		System.out.println("---------"+right.token+"---------\n"+right.value);
		stmt.printNode();
	}

}
