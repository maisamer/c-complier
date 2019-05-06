package phase2;

import phase1.Lexeme;

public class If_stmt implements Node{
	//IF ( expr ) stmt | IF ( expr ) stmt ELSE stmt
	private Lexeme iF;
	private Lexeme left;
	private Expr expr;
	private Lexeme right;
	private Stmt stmt;
	private Lexeme elSe;
	private Stmt stmt2;
	public If_stmt(Lexeme iF,Lexeme left,Expr expr,Lexeme right,Stmt stmt) {
		// TODO Auto-generated constructor stub
		this.iF=iF;
		this.left=left;
		this.expr=expr;
		this.right=right;
		this.stmt=stmt;
		this.elSe=null;
		this.stmt2=null;
	}
	public If_stmt(Lexeme iF,Lexeme left,Expr expr,Lexeme right,Stmt stmt,Lexeme elSe,Stmt stmt2) {
		// TODO Auto-generated constructor stub
		this.iF=iF;
		this.left=left;
		this.expr=expr;
		this.right=right;
		this.stmt=stmt;
		this.elSe=elSe;
		this.stmt2=stmt2;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------if_stmt-----------");
		System.out.println("---------"+iF.token+"---------\n"+iF.value);
		System.out.println("---------"+left.token+"---------\n"+left.value);
		expr.printNode();
		System.out.println("---------"+right.token+"---------\n"+right.value);
		stmt.printNode();
		if(elSe !=null) {
			System.out.println("---------"+elSe.token+"---------\n"+elSe.value);
			stmt2.printNode();
		}
	}

}
