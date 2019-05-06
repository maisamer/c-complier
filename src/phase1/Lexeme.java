package phase1;

import java.util.Comparator;

public class Lexeme implements Comparator<Lexeme> {
	public int index;
	public String value;
	public String token;
	public Lexeme(){}
	public Lexeme(int index, String value, String token) {
		this.index = index;
		this.value = value;
		this.token = token;
	}
	
	@Override
    public int compare(Lexeme o1, Lexeme o2) {
		if(o1.index>o2.index)
			return 1;
		else if(o1.index<o2.index)
			return -1;
		return 0;
    }
}