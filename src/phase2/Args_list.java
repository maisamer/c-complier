package phase2;

public class Args_list implements Node{
	//expr arg_list_dash
	Expr e;
	Arg_list_dash a;
	public Args_list(Expr e,Arg_list_dash a) {
		// TODO Auto-generated constructor stub
		this.e=e;
		this.a=a;
	}

	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("------Args_list------");
		e.printNode();
		if(a!=null)
			a.printNode();
		
	}

}
