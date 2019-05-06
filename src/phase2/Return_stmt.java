package phase2;

import phase1.Lexeme;

public class Return_stmt implements Node{
	//RETURN ; | RETURN expr ;
	private Lexeme retrn;
	private Expr expr;
	private Lexeme semi;
	public Return_stmt(Lexeme retrn,Lexeme semi) {
		// TODO Auto-generated constructor stub
		this.retrn=retrn;
		this.expr=null;
		this.semi=semi;
	}
	public Return_stmt(Lexeme retrn,Expr expr,Lexeme semi) {
		// TODO Auto-generated constructor stub
		this.retrn=retrn;
		this.expr=expr;
		this.semi=semi;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------return_stmt-----------");
		System.out.println("---------"+retrn.token+"--------- \n"+retrn.value);
		if(expr != null)
			expr.printNode();
		System.out.println("---------"+semi.token+"--------- \n"+semi.value);
	}

}
