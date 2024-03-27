import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
	
		public static void main(String[] args) throws Exception {
		
		List<Integer> nums = new ArrayList<>();
		nums.add(0);
		for(int i = 1; i <= 50; i++) {
			for(int j = 1; j <= i; j++) {
				nums.add(i);
			}
		}
		
		
		List<Integer> sums = new ArrayList<>();
		sums.add(0);
		for(int i = 1; i < nums.size(); i++) {
			int k = sums.get(i - 1) + nums.get(i);
			sums.add(k);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int ans = sums.get(b) - sums.get(a - 1);
		System.out.println(ans);	
	}
}
