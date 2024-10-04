import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		long x = -1;
		for(int b = (m / n + 1) * max; b >= 1; b /= 2) {
			while(!isValid(x + b)) x += b;
		}
		System.out.println(x + 1);
	}
 	public static boolean isValid(long x) {
 		int res = 0;
 		for(int i : arr) {
 			res += (x / i);
 		}
 		if(res >= m) return true;
 		return false;
 	}
}