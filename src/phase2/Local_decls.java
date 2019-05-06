package phase2;

public class Local_decls implements Node{
	public Local_decls local_decls;
	public Local_decl local_decl;
	public Local_decls(Local_decl local_decl) {
		// TODO Auto-generated constructor stub
		this.local_decl=local_decl;
		this.local_decls=null;
	}
	public Local_decls(Local_decls local_decls,Local_decl local_decl) {
		// TODO Auto-generated constructor stub
		this.local_decl=local_decl;
		this.local_decls=local_decls;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Local_decls-----------");
		local_decl.printNode();	
		if(local_decls != null)
			local_decls.printNode();	
		
	}

}
