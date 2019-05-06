package phase2;

public class Stmt_list implements Node{
	private Stmt_list stmt_list;
	private Stmt stmt;
	public Stmt_list(Stmt stmt) {
		// TODO Auto-generated constructor stub
		this.stmt=stmt;
		this.stmt_list=null;
	}
	public Stmt_list(Stmt_list stmt_list,Stmt stmt) {
		// TODO Auto-generated constructor stub
		this.stmt=stmt;
		this.stmt_list=stmt_list;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Stmt_list-----------");
		stmt.printNode();
		if(stmt_list !=null)
			stmt_list.printNode();
		
		
	}

}
