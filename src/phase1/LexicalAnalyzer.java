package phase1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

	private Queue<Lexeme> Tokens = new LinkedList<Lexeme>();
	public void makeAnalyzer(String in) throws IOException {
		
		Token tok = new Token();
		Map<String,String> map = tok.IntializeMap();
		// TODO Auto-generated method stub
		Tokenization tk= new Tokenization();
		List<String> tokens = tk.tokenization(in);
		List<String> Labels = new ArrayList<String>();
        Pattern pattern = null;
        boolean isInLanguage = false;
        FileWriter writer = new FileWriter("output.txt");
        String newLine = System.getProperty("line.separator");
        for (int i = 0; i < tokens.size(); i++) {
        	String res = "";
            isInLanguage = false;
            for (String key : map.keySet()) {
                pattern = Pattern.compile(key);
                if (pattern.matcher(tokens.get(i)).matches()) {
                	res = map.get(key);
                    isInLanguage = true;
                    break;
                }
            }
            if (!isInLanguage) {
            	
                writer.write("ERROR:" + " " + "'" + tokens.get(i) + "'" + " This token did not match any RE"+ newLine);
            }
            else {
            	//                      value         token
            	Tokens.add(new Lexeme(0,tokens.get(i),res));
            	writer.write("< " + res + " > " + " :  " + tokens.get(i)  + newLine);
            }
        }
        writer.close();
		
	}
	public Queue<Lexeme> getTokens(){
		return this.Tokens;
	}
	
	

}
