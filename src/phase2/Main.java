package phase2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import phase1.LexicalAnalyzer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    File f = new File("input.txt");
	    FileReader reader = null;
	    String in = "";
	    char content[] = new char[(int) f.length()];
        reader = new FileReader(f);
        reader.read(content);
        reader.close();
        in = new String(content);
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        lexicalAnalyzer.makeAnalyzer(in);
        Parser p = new Parser(lexicalAnalyzer.getTokens());
        //p.print();
        program r = p.compile();
        if(!p.error&&p.isEmpty()&&r!=null) {
        	System.out.println("correct code");
        	r.printNode();
        }else {
        	System.out.println("wrong code");
        }
        
        //p.print();
	}

}
