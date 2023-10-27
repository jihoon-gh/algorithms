import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int left = 0;
		int right = 0;
		int ans = 2000000001;
		Arrays.sort(arr);
		while(right < n && left < n) {
			int k = arr[right] - arr[left]; 
			if(k >= m) {
				ans = Math.min(ans, k);
				left++;
			}
			else {
				right++;
			}
		}
		System.out.println(ans);
		
	}
}
