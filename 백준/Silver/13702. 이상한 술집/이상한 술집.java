import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 arr = new long[n];
		 long maxVal = 0;
		 for(int i = 0; i < n; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
			 maxVal = Math.max(maxVal, arr[i]);
		 }
		 int x = 0;
		 for(long b = maxVal + 1; b >= 1; b /= 2) {
			 while(!isValid(x + b)) x += b;
 		 }
		 System.out.println(x);
	}
	public static boolean isValid(long x) {
		if(x == 0) return false;
		long res = 0;
		for(long i : arr) {
			res += (i / x);
		}
		if(res >= m) return false;
		return true;
	}
}

