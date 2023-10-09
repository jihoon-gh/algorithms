import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static int[] arr;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long ans = 0;
			Stack<Integer> s = new Stack<>();
			for(int i = n - 1; i >= 0; i--) {
				while(!s.isEmpty()) {
					if(s.peek() <= arr[i]) {
						s.pop();
					}
					else {
						ans += s.peek() - arr[i];
						break;
					}
				}
				if(s.isEmpty()) {
					s.add(arr[i]);
				}
			}
			System.out.println(ans);
		}
		return ;
	}
	
}
