
import java.io.*;
import java.util.*;

public class Main {

	static class Pair{
		public int x;
		public int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	static List<List<Pair>> plist = new ArrayList<>();
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i <= 100; i++) {
			List<Pair> tmp = new ArrayList<>();
			plist.add(tmp);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for(int i = 1; i < max; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[j][k] > i) {
						plist.get(i).add(new Pair(j, k));
					}
				}
			}
		}
		int ans = 1;
		for(int i = 0; i <= max; i++) {
			int res = 0;
			visited = new boolean[n][n];
			for(Pair p : plist.get(i)) {
				int x = p.x;
				int y = p.y;
				if(visited[x][y]) continue;
				res++;
				bfs(x, y, i);
			}
			ans = Math.max(ans, res);
		}
		System.out.println(ans);
		
	}
	public static void bfs(int x, int y,int k) {
		visited[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int a = p.x;
			int b = p.y;
			for(int i = 0; i < 4; i++) {	
				int rx = a + dx[i];
				int ry = b + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;
				if(visited[rx][ry]) continue;
				if(arr[rx][ry] > k) {
					visited[rx][ry] = true;
					q.add(new Pair(rx, ry));
				}
			}
		}
	}
}