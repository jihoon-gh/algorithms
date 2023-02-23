
import java.io.*;

public class Main {
	
	static int[][] lcs = new int[4001][4001];
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				}
				else {
					lcs[i][j] = 0;
				}
				ans = Math.max(ans, lcs[i][j]);
			}
		}
		System.out.println(ans);
		
	}

}
