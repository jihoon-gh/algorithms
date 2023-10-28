import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, d, k, c;
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int ans = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 0;
		int right = -1;
		int res = 0;
		int[] kinds = new int[d + 1];
		kinds[c]++;
		res++;
		Set<Integer> hs = new HashSet<>();
		while(left < n) {
			if(right - left < k - 1) {
				right++;
				hs.add(arr[right]);
				kinds[arr[right]]++;
				if(kinds[arr[right]] == 1) {
					res++;
				}
				continue;
			}
			else {
				
				ans = Math.max(ans, res);
				
				kinds[arr[left]]--;
				if(kinds[arr[left]] == 0) {
					res--;
				}
				left++;
				right++;
				kinds[arr[right % n]]++;
				if(kinds[arr[right % n]] == 1) {
					res++;
				}
			}
		}
		System.out.println(ans);
	}
}
