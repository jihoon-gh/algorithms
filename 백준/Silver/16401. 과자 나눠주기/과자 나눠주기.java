import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = 0;
		for(int b = 1000000001; b >= 1; b /= 2) {
			while(!isValid(x + b)) x += b;
		}
		System.out.println(x);
		
	}
	public static boolean isValid(int k) {
		int res = 0;
		if(k == 0) return false;
		for(int i = 0; i < m; i++) {
			res += arr[i] / k;
		}
		if(res >= n) {
			return false;
		}
		return true;
	}
}
