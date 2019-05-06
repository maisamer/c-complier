package phase2;

public class Final implements Node{
    Final_Lit final_lit;
    Final_id final_id;
    public Final(Final_id fid,Final_Lit flit) {
		// TODO Auto-generated constructor stub
    	this.final_lit = flit;
    	this.final_id = fid;
	}
    
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------Final---------");
		if(final_id !=null)
			final_id.printNode();
		else if(final_lit != null)
			final_lit.printNode();
	}

}
