import java.util.*;
import java.io.*;
import java.util.stream.Collectors;



public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			String[] splits = s.split("");
			Stack<String> st = new Stack<>();
			boolean isOk = true;
			for(String tmp : splits) {
				if(tmp.equals("(")) {
					st.add("(");
				}
				else {
					if(st.empty() || st.peek().equals(")")) {
						isOk = false;
						break;
					}
					else {
						st.pop();
					}
				}
			}
			if(!st.isEmpty()) {
				isOk = false;
			}
			if(isOk) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
