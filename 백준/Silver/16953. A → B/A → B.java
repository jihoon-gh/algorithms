import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long k  = getRes(n, m, 1);
		if(k == 1000000000) {
			k = -1;
		}
		System.out.println(k);
	}
	public static long getRes(long n, long m, long dist) {
		if( n > m) {
			return 1000000000;
		}
		if(n == m ) {
			return dist;
		}
		return Math.min(getRes(n * 10 + 1, m, dist+1), getRes(n * 2, m, dist + 1));
	}
}
