import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static class Pair{
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static int[][] arr;
	static int[][] tmpArr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m;
	static List<Pair> dustList = new ArrayList<>();
	static List<Pair> robots = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					robots.add(new Pair(i, j));
				}
				else if(arr[i][j] != 0) {
					dustList.add(new Pair(i, j));
				}
			}
		}
		
		for(int tc = 0; tc < t; tc++) {
			tmpArr = new int[n][m];
			dustList = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] >= 1) {
						dustList.add(new Pair(i, j));
					}
				}
			}
			
			for(Pair p : dustList) {
				int count = 0;
				if(arr[p.x][p.y] == 0) continue;
				for(int i = 0; i < 4; i++) {
					int rx = p.x + dx[i];
					int ry = p.y + dy[i];
					if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
					if(arr[rx][ry] == -1) continue;
					count++;
					tmpArr[rx][ry] += arr[p.x][p.y] / 5;
				}
				arr[p.x][p.y] = arr[p.x][p.y] - count * (arr[p.x][p.y] / 5);
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					arr[i][j] += tmpArr[i][j];
				}
			}
			
			counterClock(robots.get(0));
			clock(robots.get(1));
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-----------------------");
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				ans += arr[i][j];
			}
		}
		System.out.println(ans + 2);
		
	}
	public static void counterClock(Pair p) {
		int x = p.x;
		int tmp = 0;
		int tmp2 = 0;
		for(int i = 1; i < m; i++) {
			tmp2 = arr[x][i];
			arr[x][i] = tmp;
			tmp = tmp2;
		}
		for(int i = x - 1; i >= 0; i--) {
			tmp2 = arr[i][m - 1];
			arr[i][m - 1] = tmp;
			tmp = tmp2;
		}
		for(int i = m - 2; i >= 0; i--) {
			tmp2 = arr[0][i];
			arr[0][i] = tmp;
			tmp = tmp2;
		}
		for(int i = 1; i <= x - 1; i++) {
			tmp2 = arr[i][0];
			arr[i][0] = tmp;
			tmp = tmp2;
		}
	}
	public static void clock(Pair p) {
		int x = p .x;
		int tmp = 0;
		int tmp2 = 0;
		for(int i = 1; i < m; i++) {
			tmp2 = arr[x][i];
			arr[x][i] = tmp;
			tmp = tmp2;
		}
		for(int i = x + 1; i < n; i++) {
			tmp2 = arr[i][m - 1];
			arr[i][m - 1] = tmp;
			tmp = tmp2;
		}
		for(int i = m - 2; i >= 0; i--) {
			tmp2 = arr[n - 1][i];
			arr[n - 1][i] = tmp;
			tmp = tmp2;
		}
		for(int i = n - 2; i >= x + 1; i--) {
			tmp2 = arr[i][0];
			arr[i][0] = tmp;
			tmp = tmp2;
		}
	}
}
