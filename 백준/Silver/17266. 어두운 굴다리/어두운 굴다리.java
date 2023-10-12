import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static int[] tmp;
	static int gap = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i >= 1) {
				gap = Math.max(gap, (arr[i] - arr[i - 1] + 1) / 2);
			}
		}
		gap = Math.max(gap, arr[0]);
		gap = Math.max(gap, n - arr[arr.length - 1]);
		
		int x = 0;
		for(int b = n / 2 + 1 ; b >= 1; b /= 2) {
			while(!isValid(x + b)) x += b;
		}
		System.out.println(x + 1);
	}
	public static boolean isValid(int k) {
		
		if(k >= gap) return true;
		else return false;
	}
}
