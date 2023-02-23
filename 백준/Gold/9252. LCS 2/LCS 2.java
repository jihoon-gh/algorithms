import java.util.*;
import java.util.stream.Collectors;
import java.math.*;
import java.io.*;
			
public class Main {
		
	static int[][] dp;
	static int[][] directions;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int left = s1.length();
		int right = s2.length();
		List<Character> ans = new ArrayList<>();
		while(left>0 && right > 0) {
			if(s1.charAt(left-1)==s2.charAt(right-1)) {
				ans.add(s1.charAt(left-1));
				left--;
				right--;
			}
			else {
				if(dp[left][right]==dp[left-1][right]) {
					left--;
				}
				if(dp[left][right]==dp[left][right-1]) {
					right--;
				}
			}
		}
		
		System.out.println(ans.size());
		Collections.reverse(ans);
		for(Character c : ans) {
			System.out.print(c);
		}
		
	}
}