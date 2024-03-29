import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for(int k = 0; k < n; k++) {
			dp[k] = 1;
			for(int i = 0; i < k; i++) {
				if(arr[i] < arr[k]) {
					dp[k] = Math.max(dp[k], dp[i] + 1);
				}
			}
		}
		int ans = Arrays.stream(dp).max().getAsInt();
		System.out.println(ans);
	}
}