package phase2;

public class Param_list implements Node{
	public Param param;
	public Param_list_dash param_list_dash;
	public Param_list(Param param,Param_list_dash param_list_dash) {
		// TODO Auto-generated constructor stub
		this.param = param ;
		this.param_list_dash = param_list_dash;
	}
	public Param_list(Param param) {
		// TODO Auto-generated constructor stub
		this.param = param ;
		this.param_list_dash =null;
	}

	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		param.printNode();
		if(param_list_dash != null)
			param_list_dash.printNode();
		
	}

}
