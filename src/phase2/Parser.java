package phase2;

import java.util.LinkedList;
import java.util.Queue;

import phase1.Lexeme;
import phase1.Token;

public class Parser {
	private Queue<Lexeme> Tokens = new LinkedList<Lexeme>();
	private program root = null;
	boolean fun,error;
	public Parser(Queue<Lexeme> Tokens) {
		// TODO Auto-generated constructor stub
		fun=false;
		error=false;
		this.Tokens=Tokens;
	}
	public program compile () {
		root = program();
		return root;
	}
	private program program() {
		program p=null;
		// program -> decl_list
		decl_list d = decl_list();
		if(d !=null)
			p = new program(d);
		return p;
	}
	private decl_list decl_list() {
		// decl_list -> decl decl_list_dash
		decl d = decl();
		decl_list_dash dld = decl_list_dash();
		if(d == null) 
			return null;
		if(dld == null)
			return new decl_list(d);
		return new decl_list(d,dld);
		
	}
	private decl decl() {
		// decl -> var_decl | fun_decl
		Var_decl v = var_decl();
		if(v ==null) {
			if(fun) {
				Fun_decl fd = fun_decl();
				if(fd != null)
					return new decl(fd);
			}
		}
		else
			return new decl(v);
		
		return null;
	}
	private decl_list_dash decl_list_dash() {
		// decl_list_dash -> decl decl_list_dash | e
		
		decl d=decl();
		if(d!=null) {
			decl_list_dash dld2 = decl_list_dash();
			return new decl_list_dash(d,dld2);
		}
		
		return null;
		
	}

	private Var_decl var_decl() {
		// var_decl -> type_spec IDENT bractes ;
		Queue<Lexeme> cp = new LinkedList<Lexeme>(Tokens);
		
		if(Tokens.peek() == null) {
			return null;
		}
		Lexeme type = Tokens.poll();
		if((type == null ||!isType(type))&& Tokens.peek() != null) {		
			System.out.println("type not define heree");
			error=true;
			return null;
		}
		Lexeme id = Tokens.poll();
		if(id == null || !id.token.equals("ID")) {
			error=true;
			System.out.println("name not define");
			return null;
		}
		if(Tokens.peek().value.equals("[")) {
			Lexeme left = Tokens.poll();
			Lexeme right = Tokens.poll();
			Lexeme semi = Tokens.poll();
			if(right.value.equals("]")&&semi.value.equals(";")) {
				return new Var_decl(new Type_spec(type), id,new Bractes(left, right), semi);
			}
			error=true;
			System.out.println("syntax erorr");
			return null;
		}
		else if(Tokens.peek().value.equals("(")) fun = true;
		else if(Tokens.peek()==null ||!Tokens.peek().value.equals(";")) {
			System.out.println("missing semicolom here" + type.value + " " + id.value);
			error=true;
			return null;
		}
		else if(Tokens.peek().value.equals(";")) {
			Lexeme semi = Tokens.poll();
			return new Var_decl(new Type_spec(type), id,semi);
		}	
		Tokens = cp;
		return null;
	}
	private boolean isType(Lexeme type) {
		return type.token.equals("BOOL")||type.token.equals("INT")||type.token.equals("FLOAT")||type.token.equals("VOID")||type.token.equals("string");
	}
	private Fun_decl fun_decl() {
		// type_spec IDENT ( params ) compound_stmt
		fun=false;
		Lexeme type = Tokens.poll();
		Lexeme id = Tokens.poll();
		Lexeme left = Tokens.poll();
		if(left.value.equals("(")) {
			Params p = params();
			if(p != null) {
				Lexeme right = Tokens.poll();
				if(right !=null&&right.value.equals(")")) {
					Compound_stmt c = compound_stmt();
					if(c!=null)
						return new Fun_decl(new Type_spec(type), id, left, p, right, c);
					else {
						error=true;
						System.out.println("syntax erorr "+"missing fun body bracets Fun_decl");
					}
				}
				else {
					error = true;
					System.out.println("syntax erorr "+"missing right bracets Fun_decl");
				}
			}
		}
		
		return null;
	}
	private Compound_stmt compound_stmt() {
		// TODO Auto-generated method stub
		// compound_stmt -> { local_decls stmt_list } 
		if(Tokens.peek()!=null && Tokens.peek().value.equals("{")) {
			Lexeme left = Tokens.poll();
			Local_decls l= local_decls();
			Stmt_list s = stmt_list();

			if(Tokens.peek() !=null && Tokens.peek().value.equals("}")) {
				Lexeme right = Tokens.poll();
				return new Compound_stmt(left, l, s, right);
			}
			
		}
		return null;
	}
	private Stmt_list stmt_list() {
		// TODO Auto-generated method stub
		// stmt_list -> stmt_list stmt | e
		Stmt ss = stmt();
		if(ss!=null) {
			Stmt_list s = stmt_list();
			return new Stmt_list(s,ss);
		}
		return null;
	}
	private Stmt stmt() {
		// TODO Auto-generated method stub
		//stmt -> expr_stmt | compound_stmt | if_stmt | while_stmt |return_stmt | break_stmt
		Expr_stmt e = expr_stmt();
		if(e==null) {
			Compound_stmt c = compound_stmt();
			if(c==null) {
				If_stmt i = if_stmt();
				if(i==null) {
					While_stmt w =while_stmt();
					if(w==null) {
						Return_stmt r = return_stmt();
						if(r==null) {
							Break_stmt b=break_stmt();
							if(b!=null) {
								return new Stmt(b);
							}
						}else {
							return new Stmt(r);
						}
					}else {
						return new Stmt(w);
					}
				}else {
					return new Stmt(i);
				}
			}else {
				return new Stmt(c);
			}
		}else {
			return new Stmt(e);
		}
		return null;
	}
	private Break_stmt break_stmt() {
		// TODO Auto-generated method stub
		//break ;
		
		if(Tokens.peek()!=null&&Tokens.peek().value.equals("break")) {
			Lexeme br = Tokens.poll();
			Lexeme semi = Tokens.poll();
			if(semi!=null&&semi.value.equals(";")) {
				return new Break_stmt(br,semi);
			}else {
				error=true;
				System.out.println("missing semicolom");
			}
		}
		return null;
	}
	private Return_stmt return_stmt() {
		// TODO Auto-generated method stub
		//return_stmt -> RETURN ; | RETURN expr ;
		if(Tokens.peek()!=null&&Tokens.peek().value.equals("return")) {
			Lexeme re = Tokens.poll();
			if(Tokens.peek()!=null&&Tokens.peek().value.equals(";")) {
				Lexeme semi = Tokens.poll();
				return new Return_stmt(re, semi);
			}
			Expr e =expr();
			if(e!=null) {
				if(Tokens.peek()!=null&&Tokens.peek().value.equals(";")) {
					Lexeme semi = Tokens.poll();
					return new Return_stmt(re,e, semi);
				}else {
					error=true;
					System.out.println("missing semicolom");
				}
			}else {
				error=true;
				System.out.println("missing expr or semicolom");
			}
		}
		
		return null;
	}
	private Expr expr() {
		// TODO Auto-generated method stub
		// expr->b_or
		B_or b = b_or();
		if(b !=null)
			return new Expr(b);
		return null;
	}
	private B_or b_or() {
		// B_or -> B_and B_or_dash
		B_and b=b_and();
		if(b!=null) {
			B_or_dash bs =b_or_dash();
			return new B_or(b, bs);
		}
		return null;	
	}
	private B_or_dash b_or_dash() {
		// TODO Auto-generated method stub
		// b_or_dash -> or b_and dash b_or_dash | e
        if(Tokens.peek() != null && Tokens.peek().token.equals("OR")) {
        	Lexeme or = Tokens.poll();
        	B_and b_and = b_and();
        	if(b_and !=null) {
        		B_or_dash bs = b_or_dash();
        		return new B_or_dash(or, b_and, bs);
        	}else {
        		error = true;
        		System.out.println("missing expr after or");
        	}
        }
		return null;
	}
	private B_and b_and() {
		// B_and -> GE B_and_dash
		GE ge =ge();
		if(ge!=null) {
			B_and_dash bs = b_and_dash();
			return new B_and(ge, bs);
		}
		return null;
	}
	private GE ge() {
		// TODO Auto-generated method stub
		// GE -> LE GE_dash 
		LE le = le();
		if(le!=null) {
			GE_dash ge = ge_dash();
			return new GE(le, ge);
		}
		return null;
	}
	private GE_dash ge_dash() {
		// TODO Auto-generated method stub
		// GE_dash -> >= LE GE_dash | e
		if(Tokens.peek()!=null && Tokens.peek().token.equals("GREAT_EQ")) {
			Lexeme op = Tokens.poll();
			LE le = le();
			if(le!=null) {
				GE_dash ge = ge_dash();
				return new GE_dash(op,le,ge);
			}else {
        		error = true;
        		System.out.println("missing expr after or");
			}
		}
		return null;
	}
	private LE le() {
		// TODO Auto-generated method stub
		// LE -> GT LE_dash
		GT gt = gt();
		if(gt !=null) {
			LE_dash le = le_dash();
			return new LE(gt,le);
		}
		return null;
	}
	private LE_dash le_dash() {
		// TODO Auto-generated method stub
		// LE_dash -> <= GT LE_dash | e
		if(Tokens.peek()!=null && Tokens.peek().token.equals("LESS_EQ")) {
			Lexeme op = Tokens.poll();
			GT gt = gt();
			if(gt!=null) {
				LE_dash le = le_dash();
				return new LE_dash(op,gt,le);
			}else {
        		error = true;
        		System.out.println("missing expr after or");
			}
		}
		return null;
	}
	private GT gt() {
		// TODO Auto-generated method stub
		// GT -> LT GT_dash
		LT lt = lt();
		if(lt !=null) {
			GT_dash gt = gt_dash();
			return new GT(lt,gt);
		}
		return null;
	}
	private GT_dash gt_dash() {
		// TODO Auto-generated method stub
		// GT_dash -> > LT GT_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals(">")) {
			Lexeme op = Tokens.poll();
			LT lt = lt();
			if(lt!=null) {
				GT_dash le = gt_dash();
				return new GT_dash(op,lt,le);
			}else {
        		error = true;
        		System.out.println("missing expr after >");
			}
		}
		return null;
	}
	private LT lt() {
		// TODO Auto-generated method stub
		// LT->NE LT_dash
		NE ne = ne();
		if(ne != null) {
			LT_dash lt = lt_dash();
			return new LT(ne, lt);
		}
		return null;
	}
	private LT_dash lt_dash() {
		// TODO Auto-generated method stub
		// LT_dash -> < NE LT_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("<")) {
			Lexeme op = Tokens.poll();
			NE ne = ne();
			if(ne!=null) {
				LT_dash bs = lt_dash();
				return new LT_dash(op, ne, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after <");
			}
		}
		return null;
	}
	private NE ne() {
		// TODO Auto-generated method stub
		// NE-> EQ NE_dash
		EQ eq = eq();
		if(eq != null) {
			NE_dash ne = ne_dash();
			return new NE(eq, ne);
		}
		return null;
	}
	private NE_dash ne_dash() {
		// TODO Auto-generated method stub
		// NE_dash -> != EQ NE_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("!=")) {
			Lexeme op = Tokens.poll();
			EQ eq = eq();
			if(eq!=null) {
				NE_dash bs = ne_dash();
				return new NE_dash(op, eq, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after !=");
			}
		}
		return null;
	}
	private EQ eq() {
		// TODO Auto-generated method stub
		// EQ -> plus EQ_dash
		Plus p = plus();
		if(p != null) {
			EQ_dash eq = eq_dash();
			return new EQ(p, eq);
		}
		return null;
	}
	private EQ_dash eq_dash() {
		// TODO Auto-generated method stub
		// EQ_dash-> = plus EQ_dash	| e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("==")) {
			Lexeme op = Tokens.poll();
			Plus p=plus();
			if(p!=null) {
				EQ_dash bs = eq_dash();
				return new EQ_dash(op, p, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after =");
			}
		}
		return null;
	}
	private Plus plus() {
		// TODO Auto-generated method stub
		// plus -> minus plus_dash
		Minus m = minus();
		if(m != null) {
			Plus_dash pl = plus_dash();
			return new Plus(m, pl);
		}
		return null;
	}
	private Plus_dash plus_dash() {
		// TODO Auto-generated method stub
		// plus_dash -> + minus plus_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("+")) {
			Lexeme op = Tokens.poll();
			Minus p=minus();
			if(p!=null) {
				Plus_dash bs = plus_dash();
				return new Plus_dash(op, p, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after +");
			}
		}
		return null;
	}
	private Minus minus() {
		// TODO Auto-generated method stub
		// minus -> mult minus_dash
		Mult m = mult();
		if(m != null) {
			Minus_dash pl = minus_dash();
			return new Minus(m, pl);
		}
		return null;
	}
	private Minus_dash minus_dash() {
		// TODO Auto-generated method stub
		// Minus_dash-> - mult Minus_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("-")) {
			Lexeme op = Tokens.poll();
			Mult p=mult();
			if(p!=null) {
				Minus_dash bs = minus_dash();
				return new Minus_dash(op, p, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after -");
			}
		}
		return null;
	}
	private Mult mult() {
		// TODO Auto-generated method stub
		// mult -> div mult_dash
		Div v = div();
		if(v != null) {
			Mult_dash pl = mult_dash();
			return new Mult(v, pl);
		}
		return null;
	}
	private Mult_dash mult_dash() {
		// TODO Auto-generated method stub
		// mult_dash -> * div mult_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("*")) {
			Lexeme op = Tokens.poll();
			Div v=div();
			if(v!=null) {
				Mult_dash bs = mult_dash();
				return new Mult_dash(op, v, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after *");
			}
		}
		return null;
	}
	private Div div() {
		// TODO Auto-generated method stub
		// div -> mod div_dash
		Mod m = mod();
		if(m != null) {
			Div_dash pl = div_dash();
			return new Div(m, pl);
		}
		return null;
	}

	private Div_dash div_dash() {
		// TODO Auto-generated method stub
		// div_dash -> / mod div_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("/")) {
			Lexeme op = Tokens.poll();
			Mod m=mod();
			if(m!=null) {
				Div_dash bs = div_dash();
				return new Div_dash(op, m, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after /");
			}
		}
		return null;
	}
	private Mod mod() {
		// TODO Auto-generated method stub
		// mod -> Final mod_dash
		Final f = fiNal();
		if(f != null) {
			Mod_dash pl = mod_dash();
			return new Mod(f, pl);
		}
		return null;
	}
	private Mod_dash mod_dash() {
		// TODO Auto-generated method stub
		// mod_dash -> % Final mod_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals("%")) {
			Lexeme op = Tokens.poll();
			Final f=fiNal();
			if(f!=null) {
				Mod_dash bs = mod_dash();
				return new Mod_dash(op, f, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after %");
			}
		}
		return null;
	}
	private Final fiNal() {
		// TODO Auto-generated method stub
		// final -> final_lit | final_id
		Final_id fid= final_id();
		if(fid == null) {
			Final_Lit flit = final_Lit();
			if(flit == null) {

			}else {
				return new Final(fid, flit);
			}
		}else {
			return new Final(fid, null);
		}
		return null;
	}
	private Final_Lit final_Lit() {
		// TODO Auto-generated method stub
		// final_lit -> BOOL_LIT | INT_LIT | FLOAT_LIT | NEW type_spec [ expr ] |  ! expr | - expr | + expr
		Queue<Lexeme> cp = new LinkedList<Lexeme>(Tokens);
		if(isLit(Tokens.peek())) {
			Lexeme l = Tokens.poll();
			return new Final_Lit(l);
		}else if(Tokens.peek()!=null && Tokens.peek().token.equals("NEW")) {
			Lexeme nw = Tokens.poll();
			if(Tokens.peek() != null && isType(Tokens.peek())) {
				Lexeme type = Tokens.poll();
				if(Tokens.peek()!=null && Tokens.peek().value.equals("[")) {
					Lexeme left = Tokens.poll();
					Expr e = expr();
					if(e!=null) {
						if(Tokens.peek()!=null && Tokens.peek().value.equals("]")) {
							Lexeme right = Tokens.poll();
							return new Final_Lit(nw,new Type_spec(type), left, e, right);
						}else {
							error = true;
							System.out.println("missing right square bracktes in expr");
						}
					}else {
						error =true;
					}
				}else {
					error = true;
					System.out.println("missing left square bracktes in expr");
				}
			}else {
				error = true;
			}
		}else if(Tokens.peek()!=null && (Tokens.peek().value.equals("!") || Tokens.peek().value.equals("-") || Tokens.peek().value.equals("+"))) {
			Lexeme op = Tokens.poll();
			Expr e= expr();
			if(e!=null) {
				return new Final_Lit(op, e);
			}else {
				error =true;
				System.out.println("missing expr in operation "+op.value);
			}
		}
		return null;
	}
	private boolean isLit(Lexeme peek) {
		// TODO Auto-generated method stub
		return (peek != null && (peek.token.equals("STRING_LITERAL") ||peek.token.equals("BOOL_LIT") || peek.token.equals("INTEGRAL_LITERAL") || peek.token.equals("FLOAT_LITERAL")));
	}
	private Final_id final_id() {
		// TODO Auto-generated method stub
		// final_id -> IDENT | IDENT [ expr ] | IDENT ( args ) | IDENT . size |  ( expr ) | IDENT = expr | IDENT [ expr ] = expr
		if(Tokens.peek()!=null && Tokens.peek().token.equals("ID")) {
			Lexeme id = Tokens.poll();
			if(Tokens.peek()!=null && Tokens.peek().value.equals("[")) {
				Lexeme left = Tokens.poll();
				Expr e = expr();
				if(e != null) {
					if(Tokens.peek()!=null && Tokens.peek().value.equals("]")) {
						Lexeme right = Tokens.poll();
						if(Tokens.peek()!=null && Tokens.peek().value.equals("=")) {
							Lexeme eq = Tokens.poll();
							Expr ee = expr();
							if(ee!=null) {
								return new Final_id(id,left, e, right,eq,ee);
							}else {
								error = true;
								System.out.println("missing expr after =");
							}
						}else {
							return new Final_id(id,left, e, right);
						}
					}else {
						error = true;
						System.out.println("missing right square ] bracktes in expr");
					}
				}else {
					error = true;
					System.out.println("missing expr in square bracktes");
					if(Tokens.peek()!=null && Tokens.peek().value.equals("]")) {
						 Tokens.poll();
					}else {
						System.out.println("missing right square bracktes in expr");
					}
				}
			}else if(Tokens.peek()!=null && Tokens.peek().value.equals("(")) {
				Lexeme left = Tokens.poll();
				Args arg = arg();
				if(Tokens.peek()!=null && Tokens.peek().value.equals(")")) {
					Lexeme right = Tokens.poll();
					return new Final_id(id, left, arg, right);
				}else {
					error = true;
					System.out.println("missing right bracket in expr");
				}
			}else if(Tokens.peek()!=null && Tokens.peek().value.equals(".")) {
				Lexeme dot = Tokens.poll();
				if(Tokens.peek()!=null && Tokens.peek().value.equals("size")){
					Lexeme size = Tokens.poll();
					return new Final_id(id, dot, size);
				}else {
					error = true;
					System.out.println("undifine name must be size after '.' ");
				}
			}else {
				if(Tokens.peek()!=null && Tokens.peek().value.equals("=")) {
					Lexeme eq = Tokens.poll();
					Expr ee = expr();
					if(ee!=null) {
						return new Final_id(id,eq,ee);
					}else {
						error = true;
						System.out.println("missing expr after = opt (id=expr)");
					}
				}else
					return new Final_id(id);
			}
		}else if(Tokens.peek()!=null && Tokens.peek().value.equals("(")){
			Lexeme left = Tokens.poll();
			Expr e =expr();
			if(e != null) {
				if(Tokens.peek()!=null && Tokens.peek().value.equals(")")) {
					Lexeme right = Tokens.poll();
					return new Final_id(left, e, right);
				}else {
					error = true;
					System.out.println("missing right bracktes in expr");
				}
			}else {
				error = true;
				System.out.println("missing expr in bracktes");
				if(Tokens.peek()!=null && Tokens.peek().value.equals(")")) {
					 Tokens.poll();
				}else {
					System.out.println("missing right bracktes in expr");
				}
			}
		}
		return null;
	}
	private Args arg() {
		// TODO Auto-generated method stub
		// args -> arg_list | e
		Args_list a = arg_list();
		return new Args(a);
	}
	private Args_list arg_list() {
		// TODO Auto-generated method stub
		// arg_list -> expr arg_list_dash
		Expr e =expr();
		if(e!=null) {
			Arg_list_dash l = arg_list_dash();
			return new Args_list(e, l);
		}
		return null;
	}
	private Arg_list_dash arg_list_dash() {
		// TODO Auto-generated method stub
		// arg_list_dash -> , expr arg_list_dash | e
		if(Tokens.peek()!=null && Tokens.peek().value.equals(",")) {
			Lexeme coma = Tokens.poll();
			Expr e = expr();
			if(e != null) {
				Arg_list_dash a =arg_list_dash();
				return new Arg_list_dash(coma, e, a);
			}else {
	       		error = true;
        		System.out.println("missing expr after ,");
			}
		}
		return null;
	}
	private B_and_dash b_and_dash() {
		// TODO Auto-generated method stub
		// B_and_dash -> and GE B_and_dash
		if(Tokens.peek()!=null && Tokens.peek().token.equals("AND")) {
			Lexeme and = Tokens.poll();
			GE ge = ge();
			if(ge!=null) {
				B_and_dash bs = b_and_dash();
				return new B_and_dash(and, ge, bs);
			}else {
        		error = true;
        		System.out.println("missing expr after and");
			}
		}
		return null;
	}
	private While_stmt while_stmt() {
		// TODO Auto-generated method stub
		// while_stmt -> WHILE ( expr ) stmt
		if(Tokens.peek()!=null && Tokens.peek().value.equals("while")) {
			Lexeme wh = Tokens.poll();
			if(Tokens.peek() != null && Tokens.peek().value.equals("(")) {
				Lexeme left = Tokens.poll();
				Expr e = expr();
				if(e!=null) {					
					if(Tokens.peek() != null && Tokens.peek().value.equals(")")) {
						Lexeme right = Tokens.poll();
						Stmt s = stmt();
						if(s != null) {
							return new While_stmt(wh, left, e, right, s);
						}else {
							error=true;
							System.out.println("Synatax error missing while body");
						}
					}else {
						error=true;
						System.out.println("Synatax error missing brackets in while decl");
					}
				}else {
					error=true;
					System.out.println("Synatax error missing expr in while decl");
				}
			}else {
				error=true;
				System.out.println("Synatax error missing brackets in while decl");
			}
		}
		return null;
	}
	private If_stmt if_stmt() {
		// TODO Auto-generated method stub
		// if_stmt -> IF ( expr ) stmt | IF ( expr ) stmt ELSE stmt
		if(Tokens.peek() != null &&Tokens.peek().value.equals("if")) {
			Lexeme f = Tokens.poll();
			if(Tokens.peek() != null && Tokens.peek().value.equals("(")) {
				Lexeme left = Tokens.poll();
				Expr e = expr();
				if(e != null) {
					if(Tokens.peek() != null && Tokens.peek().value.equals(")")) {
						Lexeme right = Tokens.poll();
						Stmt s = stmt();
						if(s!=null) {
							if(Tokens.peek() != null &&Tokens.peek().value.equals("else")) {
								Lexeme els = Tokens.poll();
								Stmt ss=stmt();
								if(ss!=null) {
									return new If_stmt(f, left, e, right, s,els,ss);
								}else {
									error=true;
									System.out.println("Synatax error missing else body in if decl");
								}
							}else {
								return new If_stmt(f, left, e, right, s);
							}
						}else {
							error=true;
							System.out.println("Synatax error missing if body in if decl");
						}
					}else {
						error=true;
						System.out.println("Synatax error missing brackets in if decl");
					}
				}else {
					error=true;
					System.out.println("Synatax error missing expr in if decl");
				}
			}else {
				error=true;
				System.out.println("Synatax error missing brackets in if decl");
			}
		}
		return null;
	}
	private Expr_stmt expr_stmt() {
		// TODO Auto-generated method stub
		//expr_stmt -> expr ; | ; 
		if(Tokens.peek() != null && Tokens.peek().value.equals(";")) {
			Lexeme semi = Tokens.poll();
			return new Expr_stmt(semi);
		}else {
			Expr e =expr();
			if(e!=null) {
				Lexeme semi = Tokens.poll();
				if(semi != null && semi.value.equals(";")){
					return new Expr_stmt(e,semi);
				}else {
					System.out.println("missing semicolom in expr");
					error = true;
				}
			}
		}
		return null;
	}
	private Local_decls local_decls() {
		// TODO Auto-generated method stub
		// local_decls -> local_decls local_decl | e
		Local_decl l1 = local_decl();
		if(l1 != null) {
			Local_decls l2 = local_decls();
			return new Local_decls(l2,l1);
		}
		
		
		return null;
	}
	private Local_decl local_decl() {
		// TODO Auto-generated method stub
		// local_decl -> type_spec IDENT ; | type_spec IDENT [ ] ;
		if(Tokens.peek() != null && isType(Tokens.peek())) {
			Lexeme type = Tokens.poll();
			if(Tokens.peek() != null && Tokens.peek().token.equals("ID")) {
				Lexeme id = Tokens.poll();
				if(Tokens.peek() != null && Tokens.peek().value.equals("[")) {
					Lexeme left = Tokens.poll();
					if(Tokens.peek() != null && Tokens.peek().value.equals("]")) {
						Lexeme right = Tokens.poll();
						if(Tokens.peek() != null && Tokens.peek().value.equals(";")) {
							Lexeme semi = Tokens.poll();
							return new Local_decl(new Type_spec(type),new Bractes(left, right), id, semi);
						}else {
							error=true;
							System.out.println("syntax error : missing semicolom");
						}
					}else {
						error=true;
						System.out.println("syntax error : missing square brackets");
					}
				}else if(Tokens.peek() != null && Tokens.peek().value.equals(";")) {
					Lexeme un = Tokens.poll();
					return new Local_decl(new Type_spec(type), id, un);
				}else {
					error=true;
					System.out.println("syntax error : missing semicolom");
				}
			}else {
				error=true;
				System.out.println("syntax error : missing type identifier");
			}
			
		}
		return null;
	}
	private Params params() {
		// TODO Auto-generated method stub
		// params -> param_list | VOID
		if(Tokens.peek().value.equals("void")) {
			Lexeme vd = Tokens.poll();
			return new Params(vd);
		}		
		Param_list p= param_list();
		if(p !=null)
			return new Params(p);
		return null;
	}
	private Param_list param_list() {
		// TODO Auto-generated method stub
		//param_list -> param param_list_dash
		Param p = param();
		if(p!=null) {
			Param_list_dash pl =param_list_dash();
			return new Param_list(p,pl);
		}
		return null;
	}
	private Param_list_dash param_list_dash() {
		// TODO Auto-generated method stub
		//param_list_dash -> , param param_list_dash | e
		if(Tokens.peek().value.equals(",")) {
			Lexeme coma = Tokens.poll();
			Param p = param();
			if(p!=null) {
				Param_list_dash pl = param_list_dash();
				return new Param_list_dash(coma, p,pl);
			}else {
				error = true;
				System.out.println("missing variable declration");
			}
		}
		return null;
	}
	private Param param() {
		// TODO Auto-generated method stub
		// param -> type_spec IDENT | type_spec IDENT [ ]
		if(isType(Tokens.peek())) {
			Lexeme type=Tokens.poll();
			if(Tokens.peek() != null&&Tokens.peek().token.equals("ID")) {
				Lexeme id = Tokens.poll();
				if(Tokens.peek().value.equals("[")) {
					Lexeme left = Tokens.poll();
					Lexeme right = Tokens.poll();
					if(right.value.equals("]")) {
						return new Param(new Type_spec(type), id, new Bractes(left,right));
					}else {
						error=true;
						System.out.println("missing right brackets");
					}
				}
				else {
					return new Param(new Type_spec(type), id);
				}
			}else {
				error = true;
				System.out.println("missing identifier");
			}
		
		}
		return null;
	}
	public void print() {
		while(!Tokens.isEmpty()) {
			Lexeme l = Tokens.poll();
			System.out.println(l.value+" "+l.token);
		}
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Tokens.isEmpty();
	}
	
}
