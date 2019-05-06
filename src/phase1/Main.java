package phase1;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

	}

}
