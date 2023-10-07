import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
	
	static Stack<Integer> st = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			
			while(!st.isEmpty()) {
				if(st.peek() > k) {
					break;
				}else {
					st.pop();
				}
			}
			
			answer += st.size();
			st.add(k);
		}
		System.out.println(answer);
	}
}
