import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		boolean[] check = new boolean[s.length()];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'H') check[i] = true;
		}
		int ans = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'H') continue;
			int left = Math.max(0, i - k);
			int right = Math.min(n - 1, i + k);
			for(int j = left; j <= right; j++) {
				if(check[j]) {
					check[j] = false;
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}