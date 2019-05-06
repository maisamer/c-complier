package phase2;

public class decl_list_dash implements Node{
	private decl dcl;
	private decl_list_dash dcl_list_dash;
	public decl_list_dash(decl dcl,decl_list_dash dcl_list_dash) {
		// TODO Auto-generated constructor stub
		this.dcl = dcl;
		this.dcl_list_dash = dcl_list_dash;
	}
	
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------decl_list_dash-----------");
		dcl.printNode();
		if(dcl_list_dash != null) {
			dcl_list_dash.printNode();
		}
	}

}
