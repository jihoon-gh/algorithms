import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static class Pair{
		int value;
		int index;
		public Pair(int a, int b) {
			value = a;
			index = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> nums = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Stack<Pair> mono = new Stack<>();
		int[] ans = new int[n];
		for(int i = 0; i < n; i++) {
			ans[i] = -1;
		}
		for(int i = n - 1; i >= 0; i--) {
			Pair p = new Pair(nums.get(i), i);
			
			
			while(!mono.isEmpty()) {
				if(mono.peek().value <= p.value) {
					mono.pop();
				}
				else {
					ans[i] = mono.peek().value;
					mono.add(p);
					break;
				}
			}
			if(mono.isEmpty()) {
				mono.add(p);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : ans) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
