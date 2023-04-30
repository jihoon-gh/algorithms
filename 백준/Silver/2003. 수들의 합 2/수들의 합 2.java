import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		String[] splits = br.readLine().split(" ");
		for(int i = 0; i < splits.length; i++) {
			arr[i] = Integer.parseInt(splits[i]);
		}
		int left = 0;
		int right = 0;
		int ans = 0;
		while(right<n) {
			int k = getSum(arr, left, right);
			if(k == m) {
				left++;
				right++;
				ans++;
				continue;
			}
			if(k < m) {
				right++;
				continue;
			}
			if(k > m ) {
				if(left == right) {
					left++;
					right++;
					continue;
				}
				left++;
				continue;
			}
		}
		System.out.println(ans);
	}
	public static int getSum(int[] arr, int left, int right) {
		int res = 0;
		for(int i = left; i <= right; i++) {
			res += arr[i];
		}
		return res;
	}
}
