package phase2;

public class Args implements Node{
	private Args_list a;
	public Args(Args_list a) {
		// TODO Auto-generated constructor stub
		this.a=a;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("------Args------");
		a.printNode();
		
	}

}
