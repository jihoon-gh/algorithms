import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m, r, tmp, ans;
	static class Pair {
		int x, y;
		public Pair (int a, int b) {
			x = a;
			y = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		List<Pair> pairs = new ArrayList<>();
		visited = new boolean[n][m];
		arr = new int[n][m];
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a - 1][b - 1] = 1;
			pairs.add(new Pair(a - 1, b - 1));
		}
		
		ans = 0;
		for(Pair p : pairs) {
			tmp = 0;
			if(visited[p.x][p.y]) continue;
			bfs(p.x, p.y);
			ans = Math.max(tmp,  ans);
		}
		System.out.println(ans);
	}
	public static void bfs(int a, int b) {
		visited[a][b] = true;
		tmp++;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(a, b));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = now.x + dx[i];
				int ry = now.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				if(arr[rx][ry] == 1) {
					tmp++;
					q.add(new Pair(rx, ry));
				}
			}
		}
	}
}