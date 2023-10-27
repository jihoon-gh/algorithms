import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = n - 1;
		int ans = 0;
		if(n == 0) {
			System.out.println(ans);
			return ;
		}
		Arrays.sort(arr);
		while(left < right) {
			int k = arr[right] + arr[left];
			if(k == m) {
				ans++;
				left++;
				right--;
			}
			else if( k > m) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.println(ans);
		
	}
}
