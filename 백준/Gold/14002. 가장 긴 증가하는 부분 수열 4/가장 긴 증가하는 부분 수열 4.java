import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] parent = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			parent[i] = -1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
			}
		}
		int maxIdx = 0;
		int maxVal = 0;
		for(int i = 0; i < n; i++) {
			if(maxVal < dp[i]) {
				maxVal = dp[i];
				maxIdx = i;
			}
		}
		System.out.println(maxVal);
		Stack<Integer> stack = new Stack<>();
		while(maxIdx != -1) {
			stack.add(arr[maxIdx]);
			maxIdx = parent[maxIdx];
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}