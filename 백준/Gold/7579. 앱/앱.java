import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int n;
	static int m;
	static int[] memory = new int[101];
	static int[] cost = new int[101];
	static int[][] dp = new int[101][10001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int costSum = 0;
		for(int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			costSum += cost[i];
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= costSum; j++) {
				if(j - cost[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - cost[i]] + memory[i]);
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		for(int i = 0; i <= costSum; i++) {
			if(dp[n][i] >= m) {
				System.out.println(i);
				return;
			}
		}	
    }
}
