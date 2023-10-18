import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static int[][] dp;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = arr[1][1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(i == 1 & j == 1) continue;
				else if(i == 1) {
					dp[i][j] = dp[i][j - 1] + arr[i][j];
				}
				else if(j == 1) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				}
				else dp[i][j] = dp[i - 1][j] + dp[i][j - 1]  - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int ans = dp[c][d] - dp[a - 1][d] - dp[c][b - 1] + dp[a - 1][b - 1];
			System.out.println(ans);
		}
	}
}
