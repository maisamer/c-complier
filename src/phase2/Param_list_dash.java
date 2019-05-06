package phase2;

import phase1.Lexeme;

public class Param_list_dash implements Node{
	public Lexeme coma;
	public Param param;
	public Param_list_dash param_list_dash;
	public Param_list_dash(Lexeme coma,Param param) {
		this.coma=coma;
		this.param=param;
		
	}
	public Param_list_dash(Lexeme coma,Param param,Param_list_dash param_list_dash) {
		this.coma=coma;
		this.param=param;
		this.param_list_dash = param_list_dash;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------Param_list_dash------------");
		System.out.println("---------"+coma.token+"-------\n"+coma.value);
		param.printNode();
		if(param_list_dash != null)
			param_list_dash.printNode();
		
	}

}
