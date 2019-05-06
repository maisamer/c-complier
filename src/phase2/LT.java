package phase2;

public class LT implements Node{
	NE ne;
	LT_dash lt_dash;
	public LT(NE n,LT_dash l) {
		// TODO Auto-generated constructor stub
		ne=n;
		lt_dash =l;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------expr(LT)---------");
		ne.printNode();
		if(lt_dash!=null)
			lt_dash.printNode();
	}

}
