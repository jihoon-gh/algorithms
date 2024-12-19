import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[n];
			dp[0] = arr[0];
			int res = dp[0];
			for(int i = 1; i < n; i++) {
				dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
				res = Math.max(res, dp[i]);
			}
			System.out.println(res);
		}
	}
}