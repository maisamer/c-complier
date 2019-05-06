package phase2;

import phase1.Lexeme;

public class Final_id implements Node{
	// IDENT | IDENT [ expr ] | IDENT ( args ) | IDENT . size |  ( expr )
	Lexeme id;
	Lexeme one,two;
	Args args;
	Expr expr;
	Expr opt ;
	Lexeme eq;
	public Final_id(Lexeme id) { // id
		// TODO Auto-generated constructor stub
		this.id=id;
		this.one=null;
		this.two=null;
		this.args=null;
		this.expr=null;
		this.eq=null;
		this.opt=null;
	}
	public Final_id(Lexeme id,Lexeme left,Expr e,Lexeme right) { 
		// TODO Auto-generated constructor stub
		// IDENT [ expr ] 
		this.id=id;
		this.one=left;
		this.two=right;
		this.args=null;
		this.expr=e;
		this.eq=null;
		this.opt=null;
	}
	public Final_id(Lexeme id,Lexeme left,Args arg,Lexeme right) {
		// TODO Auto-generated constructor stub
		// IDENT ( args )
		this.id=id;
		this.one=left;
		this.two=right;
		this.args=arg;
		this.expr=null;
		this.eq=null;
		this.opt=null;
	}
	public Final_id(Lexeme id,Lexeme dot,Lexeme size) {
		// TODO Auto-generated constructor stub
		// IDENT . size
		this.id=id;
		this.one=dot;
		this.two=size;
		this.args=null;
		this.expr=null;
		this.eq=null;
		this.opt=null;
	}
	public Final_id(Lexeme left,Expr expr,Lexeme right) {
		// TODO Auto-generated constructor stub
		// ( expr )
		this.id=null;
		this.one=left;
		this.two=right;
		this.args=null;
		this.expr=expr;
		this.eq=null;
		this.opt=null;
	}
	
	public Final_id(Lexeme id,Lexeme left, Expr e, Lexeme right, Lexeme eq, Expr ee) {
		// TODO Auto-generated constructor stub
		// IDENT [ expr ] = expr
		this.id=id;
		this.one=left;
		this.two=right;
		this.args=null;
		this.expr=e;
		this.eq=eq;
		this.opt=ee;
	}
	public Final_id(Lexeme id2, Lexeme eq2, Expr ee) {
		// TODO Auto-generated constructor stub
		// id = expr
		this.id=id2;
		this.one=null;
		this.two=null;
		this.args=null;
		this.expr=null;
		this.eq=eq2;
		this.opt=ee;
	}
	@Override
	public void printNode() {
		// TODO Auto-generated method stub
		System.out.println("--------(Final_id)---------");
		if(id!=null) {
			if(args!=null) {
				// IDENT ( args )
				System.out.println("-------"+id.token+"-------\n"+id.value);
				System.out.println("-------"+one.token+"-------\n"+one.value);
				args.printNode();
				System.out.println("-------"+two.token+"-------\n"+two.value);
			}
			else if(expr!=null) {
				// IDENT [ expr ] | IDENT [ expr ] = expr
				if(opt != null) {
					System.out.println("-------"+id.token+"-------\n"+id.value);
					System.out.println("-------"+one.token+"-------\n"+one.value);
					expr.printNode();
					System.out.println("-------"+two.token+"-------\n"+two.value);
					System.out.println("-------"+eq.token+"-------\n"+eq.value);
					opt.printNode();
				}
				else {
					System.out.println("-------"+id.token+"-------\n"+id.value);
					System.out.println("-------"+one.token+"-------\n"+one.value);
					expr.printNode();
					System.out.println("-------"+two.token+"-------\n"+two.value);
				}
			}
		   else if(one!=null) {
				//IDENT . size
				System.out.println("-------"+id.token+"-------\n"+id.value);
				System.out.println("-------"+one.token+"-------\n"+one.value);
				System.out.println("-------"+two.token+"-------\n"+two.value);
			}
		   else if(opt != null) {
			   // IDENT = expr
			   System.out.println("-------"+id.token+"-------\n"+id.value);
			   System.out.println("-------"+eq.token+"-------\n"+eq.value);
			   opt.printNode();
		   }
		   else // ID
			   System.out.println("-------"+id.token+"-------\n"+id.value); 
		}

		else {
			// ( expr )
			System.out.println("-------"+one.token+"-------\n"+one.value);
			expr.printNode();
			System.out.println("-------"+two.token+"-------\n"+two.value);
		}
		
	}

}
