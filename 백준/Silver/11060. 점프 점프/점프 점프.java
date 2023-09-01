import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for(int i = 2; i <= n; i++) {
			dp[i] = 987654321;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(j + arr[j] >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		if(dp[n] == 987654321) {
			System.out.println(-1);
			return ;
		}
		System.out.println(dp[n]);
		
	}
}