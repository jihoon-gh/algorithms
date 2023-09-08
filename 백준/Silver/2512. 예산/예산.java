import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		m = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		if(sum <= m) {
			System.out.println(arr[n-1]);
			return ;
		}
		int x = -1;
		for(int b = 2000000000; b >= 1; b /= 2) {
			while(!isValid(b + x)) x += b;
		}
		System.out.println(x);
		
	}
	public static boolean isValid(int k) {
		int res = 0;
		for(int i : arr) {
			res += Math.min(i, k);
		}
		if(res <= m) {
			return false;
		}
		return true;
	}
}
