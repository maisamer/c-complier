package phase2;

public class decl implements Node{
	private Var_decl var_decl;
	private Fun_decl fun_decl;
	public decl (Var_decl var_decl){
		this.var_decl = var_decl;
		this.fun_decl = null;
		
	}
	public decl (Fun_decl fun_decl){
		this.fun_decl = fun_decl;
		this.var_decl = null;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------decl-----------");
		if(var_decl != null) {
			var_decl.printNode();
		}
		else if(fun_decl != null) {
			fun_decl.printNode();
		}
	}

}
