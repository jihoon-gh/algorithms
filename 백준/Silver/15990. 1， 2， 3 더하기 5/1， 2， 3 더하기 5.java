import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static long[] dp = new long[100001];
	static long[] dp1 = new long[100001];
	static long[] dp2 = new long[100001];
	static long[] dp3 = new long[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp[1] = dp1[1] = 1;
		dp[2] = dp2[2] = 1;
		dp3[3] = 1;
		for(int i = 3; i <= 100000; i++) {
			dp1[i] = (dp1[i] + (dp2[i - 1] % 1000000009 + dp3[i - 1] % 1000000009) % 1000000009) % 1000000009;
			dp2[i] = (dp2[i] + (dp1[i - 2] % 1000000009 + dp3[i - 2] % 1000000009) % 1000000009) % 1000000009;
			dp3[i] = (dp3[i] + (dp1[i - 3] % 1000000009 + dp2[i - 3] % 1000000009) % 1000000009) % 1000000009;
			dp[i] = (dp[i] % 1000000009 + dp1[i] % 1000000009) % 1000000009;
			dp[i] = (dp[i] % 1000000009 + dp2[i] % 1000000009) % 1000000009;;
			dp[i] = (dp[i] % 1000000009 + dp3[i] % 1000000009) % 1000000009;
		}
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(dp[k]);
		}
	}
}
