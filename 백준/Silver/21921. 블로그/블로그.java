import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int sum = 0;
		int count = 0;
		for(int i = 0; i < n; i++) {
			
			sum += arr[i];
			if(i < m - 1) {
				continue;
			}
			if(sum > ans) {
				ans = sum;
				count = 1;
			}
			else if(sum == ans) {
				count++;
			}
			sum -= arr[i - m + 1];
		}
		
		if(ans == 0) {
			System.out.println("SAD");
			return ;
		}
		System.out.println(ans + "\n" + count);
		
	}
}
