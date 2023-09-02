import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		for(int i = 1; i<= n; i++) {
			arr[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}