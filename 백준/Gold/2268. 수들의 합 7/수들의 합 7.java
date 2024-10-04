import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static long[] arr;
	static int s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		s = 1;
		while(s < n) {
			s *= 2;
		}
		arr = new long[s * 2];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(q == 0) System.out.println(getSum(Math.min(a, b), Math.max(a, b)));
			else edit(a, b);
		}
		
	}
	public static long getSum(int left, int right) {
		left = left + s - 1;
		right = right + s - 1;
		
		long sum = 0;
		while(left <= right) {
			if(left % 2 != 0) {
				sum += arr[left];
				left++;
			}
			if(right % 2 == 0) {
				sum += arr[right];
				right--;
			}
			left /= 2;
			right /= 2; 
		}
		return sum;
	}
	public static void edit(int idx, int val) {
		idx = idx + s - 1;
		arr[idx] = val;
		int b = idx / 2;
		while(b >= 1) {
			arr[b] = arr[b * 2] + arr[b * 2 + 1];
			b /= 2;
		}
	}
}

