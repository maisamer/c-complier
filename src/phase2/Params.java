package phase2;

import phase1.Lexeme;

public class Params implements Node{
	public Param_list param_list;
	public Lexeme vod;
	public Params(Param_list param_list) {
		this.param_list=param_list;
		vod=null;
	}
	public Params(Lexeme vod) {
		this.vod=vod;
		param_list=null;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------Params-----------");
		if(vod!=null) {
			System.out.println("---------"+vod.token+"---------\n"+vod.value);
			return;			
		}
		else if(param_list != null) {
			param_list.printNode();
		}
		
	}

}
