package phase2;

public class program implements Node{
	private decl_list decl ;
	public program(decl_list decl){
		this.decl=decl;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("-------program-------------");
		decl.printNode();
		
	}

}
