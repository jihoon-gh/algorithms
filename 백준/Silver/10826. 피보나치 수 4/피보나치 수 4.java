import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static BigInteger[] dp = new BigInteger[10001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0] = BigInteger.valueOf(0);
		dp[1] = BigInteger.valueOf(1);
		int n = Integer.parseInt(br.readLine());
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		System.out.println(dp[n]);
	}
}
