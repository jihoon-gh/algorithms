import java.util.*;
import java.util.stream.Collectors;
import java.math.*;
import java.io.*;
		
	public class Main {
		
		static boolean[][] arr = new boolean[501][501];
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					arr[i][j] = false;
				}
			}
			
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = true;
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j<= n; j++) {
						if(arr[j][k]==true && arr[k][i] == true) {
							arr[j][i] = true;
						}
					}
				}
			}
			int ans = 0;
			for(int i = 1 ; i <= n; i++) {
				if(getBefore(i, n) + getAfter(i, n) == n -1) {
					ans++;
				}
			}
			
			System.out.println(ans);
		}
		static int getBefore(int i, int n) {
			int res = 0;
			for(int j = 1; j <= n; j++) {
				if(arr[j][i]) {
					res++;
				}
			}
			return res;
		}
		static int getAfter(int i, int n) {
			int res = 0;
			for(int j = 1; j <= n; j++) {
				if(arr[i][j]) {
					res++;
				}
			}
			return res;
		}
		
		
}