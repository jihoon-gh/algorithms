import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static Set<Character> hs = new HashSet<>();
	static int gap = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hs.add('a');
		hs.add('e');
		hs.add('i');
		hs.add('o');
		hs.add('u');
		
		while(true) {
			boolean k = true;
			String s = br.readLine();
			if(s.equals("end")) return ; 
			
			char[] carr = s.toCharArray();
			int c1 = 0;
			boolean res = true;
			char b1 = '0';
			char b2 = '0';
			for(char c : carr) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') c1++;
				
				if(b1 != '0' && b2 != '0') {
					if(hs.contains(b2) && hs.contains(b1) && hs.contains(c)) {
						res = false;
					}
					if(!hs.contains(b2) && !hs.contains(b1) && !hs.contains(c)) {
						res = false;
					}
				}
				if(b1 == c) {
					if(c != 'e' && c != 'o') {
						res = false;
					}
				}
				b2 = b1;
				b1 = c; 
			}
			if(c1 == 0) res = false;
			StringBuilder sb = new StringBuilder();
			sb.append('<');
			sb.append(s);
			sb.append('>');
			sb.append(" is ");
			if(res) {
				sb.append("acceptable.");
			}
			else {
				sb.append("not acceptable.");
			}
			System.out.println(sb.toString());
		}
	}
}
