package phase2;

public class Stmt implements Node{
	private Expr_stmt expr_stmt;
	private Compound_stmt compound_stmt;
	private If_stmt if_stmt;
	private While_stmt while_stmt;
	private Return_stmt return_stmt;
	private Break_stmt break_stmt;
	public Stmt(Expr_stmt expr_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=expr_stmt;
		this.compound_stmt=null;
		this.if_stmt = null;
		this.while_stmt=null;
		this.return_stmt=null;
		this.break_stmt=null;
	}
	public Stmt(Compound_stmt compound_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=null;
		this.compound_stmt=compound_stmt;
		this.if_stmt = null;
		this.while_stmt=null;
		this.return_stmt=null;
		this.break_stmt=null;
	}
	public Stmt(If_stmt if_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=null;
		this.compound_stmt=null;
		this.if_stmt = if_stmt;
		this.while_stmt=null;
		this.return_stmt=null;
		this.break_stmt=null;
	}
	public Stmt(While_stmt while_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=null;
		this.compound_stmt=null;
		this.if_stmt = null;
		this.while_stmt=while_stmt;
		this.return_stmt=null;
		this.break_stmt=null;
	}
	public Stmt(Return_stmt return_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=null;
		this.compound_stmt=null;
		this.if_stmt = null;
		this.while_stmt=null;
		this.return_stmt=return_stmt;
		this.break_stmt=null;
	}
	public Stmt(Break_stmt break_stmt) {
		// TODO Auto-generated constructor stub
		this.expr_stmt=null;
		this.compound_stmt=null;
		this.if_stmt = null;
		this.while_stmt=null;
		this.return_stmt=null;
		this.break_stmt=break_stmt;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		if(compound_stmt !=null)
			compound_stmt.printNode();
		else if(if_stmt != null)
			if_stmt.printNode();
		else if(while_stmt !=null)
			while_stmt.printNode();
		else if(break_stmt !=null)
			break_stmt.printNode();
		else if(return_stmt !=null)
			return_stmt.printNode();
		else if(expr_stmt != null)
			expr_stmt.printNode();
		
		
	}

}
