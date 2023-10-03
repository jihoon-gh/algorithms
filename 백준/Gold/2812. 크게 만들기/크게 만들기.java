import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static Stack<Character> st = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		char[] carr = br.readLine().toCharArray();
		
		int count = 0;
		int i;
		for(i = 0; i < n; i++) {
			char c = carr[i];
			
			while(!st.isEmpty()) {
				if(st.peek() >= c) {
					st.add(c);
					break;
				}
				else {
					st.pop();
					count++;
					if(count == k) {
						break;
					}
				}
			}
			if(count == k) {
				break;
			}
			if(st.isEmpty()) {
				st.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(count == k) {
			for(int j = n - 1; j >= i; j--) {
				sb.append(carr[j]);
			}
			while(!st.isEmpty()) {
				char c = st.pop();
				sb.append(c);
			}
			System.out.println(sb.reverse().toString());
		}
		else {
			while(count != k) {
				count++;
				st.pop();
			}
			while(!st.isEmpty()) {
				while(!st.isEmpty()) {
					char c = st.pop();
					sb.append(c);
				}
				System.out.println(sb.reverse().toString());
			}
		}
	}
}
