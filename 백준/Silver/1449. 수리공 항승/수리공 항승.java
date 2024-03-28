import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		boolean[] map = new boolean[1001];
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(map[arr[i]]) continue;
			int k = Math.min(arr[i] + l - 1, 1000);
			for(int j = arr[i]; j <= k; j++) {
				map[j] = true;
			}
			ans++;
		}
		System.out.println(ans);
	}
}