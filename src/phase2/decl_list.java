package phase2;

public class decl_list implements Node{
	private decl dcl ;
    private decl_list_dash dcl_list_dash;
    public decl_list(decl dcl,decl_list_dash dcl_list_dash) {
    	this.dcl = dcl;
    	this.dcl_list_dash = dcl_list_dash;
    }
    public decl_list(decl dcl) {
    	this.dcl = dcl;
    	this.dcl_list_dash = null;
    }
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("---------decl_list-----------");
		dcl.printNode();
		if(dcl_list_dash != null) {
			dcl_list_dash.printNode();
		}
	}
	
}
