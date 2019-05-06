package phase2;

import phase1.Lexeme;

public class Compound_stmt implements Node{
	// compound_stmt -> { local_decls stmt_list } 
	public Lexeme left;
	public Local_decls local_decls;
	public Stmt_list stmt_list;
	public Lexeme right;
	public Compound_stmt(Lexeme left,Local_decls local_decls,Stmt_list stmt_list,Lexeme right) {
		// TODO Auto-generated constructor stub
		this.left=left;
		this.local_decls=local_decls;
		this.stmt_list=stmt_list;
		this.right=right;
	}

	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Compound_stmt-----------");
		System.out.println("---------"+left.token+ "---------\n" +left.value);
		if(local_decls != null)
			local_decls.printNode();
		if(stmt_list != null)
			stmt_list.printNode();
		System.out.println("---------"+right.token+ "---------\n" +right.value);		
	}

}
