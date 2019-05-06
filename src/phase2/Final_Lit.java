package phase2;

import phase1.Lexeme;

public class Final_Lit implements Node{
	// BOOL_LIT | INT_LIT | FLOAT_LIT | NEW type_spec [ expr ] |  ! expr | - expr | + expr
    Lexeme lit;
    Type_spec type;
    Lexeme left,right;
    Expr expr;
    public Final_Lit(Lexeme l) {
		// TODO Auto-generated constructor stub
    	this.lit=l;
	}
    public Final_Lit(Lexeme nw,Type_spec type,Lexeme left,Expr e,Lexeme right) {
		// TODO Auto-generated constructor stub
    	this.lit=nw;
    	this.type=type;
    	this.left=left;
    	this.right=right;
    	this.expr=e;
	}
    public Final_Lit(Lexeme op,Expr e) {
		// TODO Auto-generated constructor stub
    	this.lit=op;
    	this.type=null;
    	this.left=null;
    	this.right=null;
    	this.expr=e;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------(Final_lit)---------");
		System.out.println("-------"+lit.token+"-------\n"+lit.value);
		if(type !=null) {
			type.printNode();
			System.out.println("-------"+left.token+"-------\n"+left.value);
			expr.printNode();
			System.out.println("-------"+right.token+"-------\n"+right.value);
		}else if(expr != null){
			expr.printNode();
		}
		
	}
	

}
