import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int[] arr;
	static int n;
	static int s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		s = 1;
		while (s < n) {
			s *= 2;
		}
		arr = new int[2 * s];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 100000001;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = s; i < s + n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int k = i / 2;
			while(k >= 1) {
				arr[k] = Math.min(arr[k * 2], arr[k * 2 + 1]);
				k /= 2;
			}
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x == 1) {
				edit(a, b);
			}
			else {
				getMin(a, b);
			}
		}
	}
	public static void edit(int i, int x) {
		i = i + s - 1;
		arr[i] = x;
		int k = i / 2;
	
		while(k >= 1) {
			arr[k] = Math.min(arr[k * 2], arr[k * 2 + 1]);
			k /= 2;
		}
	}
	public static void getMin(int left, int right) {
		left = left + s - 1;
		right = right + s - 1;
		int res = 1000000001;
		while(left <= right) {
			if(left % 2 != 0) {
				res = Math.min(arr[left], res);
				left++;
			}
			if(right % 2 == 0) {
				res = Math.min(arr[right], res);
				right--;
			}
			left /= 2;
			right /= 2;
		}
		System.out.println(res);
	}
}
