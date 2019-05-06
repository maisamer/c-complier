package phase1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenization {
	String data = "";
	int cnt =0;
	Token tok = new Token();
	Map<String,String> map = tok.IntializeMap();
	public List<String> tokenization(String str){
		List<String> tokens = new ArrayList<>();
        tokens = First_split(str);
        tokens = Second_split(tokens);
        return tokens;
	}
	private ArrayList<String> First_split(String str) {
		data = str;
		ArrayList<String> tokens = new ArrayList<String>();
        String arr[] = str.split("\\r?\\n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replaceAll("\\s", " ");
        }
        for (int i = 0; i < arr.length; i++) {
            int delm = 0, index = 0;
            while (arr[i].length() > 0) {
            	
                index = Integer.MAX_VALUE;
                delm = arr[i].indexOf(" ");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("+");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("{");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("}");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("[");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("]");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("(");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf(")");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf(",");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf(";");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("!");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("=");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("-");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("*");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("/");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("%");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("<");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf(">");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }
                delm = arr[i].indexOf("\"");
                if (index < delm || delm == -1) {
                    index = index;
                } else {
                    index = delm;
                }

                if (index == Integer.MAX_VALUE) {
                    tokens.add(arr[i]);
                    break;
                } else if (index != 0) {
                    tokens.add(arr[i].substring(0, index));
                }
                if (!arr[i].substring(index, index + 1).equals(" ")) {
                    tokens.add(arr[i].substring(index, index + 1));
                }
                arr[i] = arr[i].substring(index + 1, arr[i].length());
            }
        }
        return tokens;
    }
	
	private List<String> Second_split(List<String> tokens) {
		int number=1;
	        for (int i = 0; i < tokens.size() - 1; i++) {
	        	if (tokens.get(i).equals("/") && tokens.get(i + 1).equals("*")) {
	                tokens.set(i, "/*");
	                tokens.remove(i + 1);
	                String str = "";
	                for (int j = i + 1; j < tokens.size() - 1; j++) {
	                    str = str + tokens.get(j);
	                    tokens.remove(j);
	                    if (tokens.get(j).equals("*") && tokens.get(j + 1).equals("/")) {
	                        tokens.remove(j);
	                        tokens.remove(j);
	                        str = str + "*/";
	                        break;
	                    }
	                    j--;

	                }
	                tokens.set(i, "/*" + str);
	                str = tokens.get(i);
	                if (tokens.get(i - 1).equals("\"") && tokens.get(i + 1).equals("\"")) {
	                    tokens.set(i, "\"" + str + "\"");
	                    tokens.remove(i - 1);
	                    tokens.remove(i + 1);
	                }
	            } else if (tokens.get(i).equals("\"")) {
	                String str = "";
	                for (int j = i + 1; j < tokens.size() - 1; j++) {
	                    str = str + tokens.get(j);
	                    tokens.remove(j);
	                    if (tokens.get(j).equals("\"")) {
	                        tokens.remove(j);
	                        str = str + "\"";
	                        break;
	                    }
	                    j--;
	                }
	                tokens.set(i, "\"" + str);
	            } else if (tokens.get(i).equals("/") && tokens.get(i + 1).equals("/")) {
	            		            	
	        		Pattern pattern = Pattern.compile("[/][/].*");
	        		Matcher matcher = pattern.matcher(data);	
	        		String ma="";
	        		cnt=0;
	        		while (matcher.find()) {
	        			cnt++;	        			
	        			ma =matcher.group();
	        			if(cnt>=number) {
	        				number++;
	        				break;
	        			}
	        		}
	        		tokens.set(i, ma);
	        		int u =i+2;
	        		String arr[] = ma.split(" ");
	        		for(int j=1;j<arr.length;j++) {
	        			if(arr[j].equals(tokens.get(u))) {
	        				tokens.remove(u);
	        			}
	        			else
	        				break;
	        		}
	        		tokens.remove(i+1);
	            } else if (tokens.get(i).equals("=")) {
	            	if(tokens.get(i + 1).equals("=")) {
		                tokens.set(i, "==");
		                tokens.remove(i + 1);
		             }
	            	else {
	            		tokens.set(i, "=");
	            	}
	            } else if (tokens.get(i).equals("!") && tokens.get(i + 1).equals("=")) {
	                tokens.set(i, "!=");
	                tokens.remove(i + 1);
	            } else if (tokens.get(i).equals("&"))  {
	            	if(tokens.get(i + 1).equals("&")) {
		                tokens.set(i, "&&");
		                tokens.remove(i + 1);
		             }
	            	else {
	            		tokens.set(i, "&");
	            	}
	            } else if (tokens.get(i).equals("|")) {
	            	if(tokens.get(i + 1).equals("|")) {
		                tokens.set(i, "||");
		                tokens.remove(i + 1);
		             }
	            	else {
	            		tokens.set(i, "|");
	            	}
	            } else if (tokens.get(i).equals("<") && tokens.get(i + 1).equals("=")) {
	                tokens.set(i, "<=");
	                tokens.remove(i + 1);
	            } else if (tokens.get(i).equals(">") && tokens.get(i + 1).equals("=")) {
	                tokens.set(i, ">=");
	                tokens.remove(i + 1);
	            } else if (tokens.get(i).equals(".")) {
	                Pattern p =Pattern.compile("\"[0-9]\\\\d*\\\\.[0-9]\\\\d*\"");
	                
	                if(p.matcher(tokens.get(i + 1)).matches()&&p.matcher(tokens.get(i - 1)).matches()){
	                    tokens.set(i, tokens.get(i - 1) + "." + tokens.get(i + 1));
	                    tokens.remove(i + 1);
	                    tokens.remove(i - 1);
	                } 


	            }
	        }
	        return tokens;
	    }


}
