import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static Stack<Integer> st1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st1 = new Stack<>();
		
			boolean checker = false;
			String s = br.readLine();
			if(s.equals(".")) break;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					st1.add(1);
				}
				if(s.charAt(i) == ')') {
					if(st1.isEmpty() || st1.peek() == 2) {
						checker = true;
						break;
					}
					else {
						st1.pop();
					}
				}
				if(s.charAt(i) == '[') {
					st1.add(2);
				}
				if(s.charAt(i) == ']') {
					if(st1.isEmpty() || st1.peek() == 1) {
						checker = true;
						break;
					}
					else {
						st1.pop();
					}
				}
			}
			if(checker == true || !st1.isEmpty()) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
		}
		return;
	}
}
