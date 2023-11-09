import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static int[] tmp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			
			int left = 0;
			int right = 0;
			tmp = new int[n];
			while(left <= n - 1 && right <= m - 1) {
				if(a[left] > b[right]) {
					tmp[left]++;
					right++;
				}
				else {
					if(left == n - 1) break;
					tmp[left + 1] += tmp[left];
					left++;	
				}
			}
			if(right == m) {
				for(int i = left + 1; i < n; i++) {
					tmp[i] = tmp[left];
				}
			}
			int sum = 0;
			sum = Arrays.stream(tmp).sum();
			System.out.println(sum);
		}
	}
}
