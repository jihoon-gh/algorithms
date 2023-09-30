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
		int[] arr = new int[n];
		int[] ans = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Pair> mono = new Stack<>();
		for(int i = 0; i < n; i++) {
			Pair p = new Pair(arr[i], i);
			
			while(!mono.isEmpty()) {
				if(mono.peek().value > p.value) {
					ans[i] = mono.peek().index;
					mono.add(p);
					break;
				}
				else mono.pop();
			}
			if(mono.isEmpty()) {
				ans[i] = -1;
				mono.add(p);
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print((ans[i]+ 1) + " ");
		}
	}
}
