import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int n;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int x;
	static int y;
	
	static class Pair{
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n][n];
			dist = new int[n][n];
			int a, b;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			bfs(a, b);
			System.out.println(dist[x][y]);
		}
	}
	public static void bfs(int a, int b) {
		dist[a][b] = 0;
		visited[a][b] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(a, b));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i < 8; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				dist[rx][ry] = dist[p.x][p.y] + 1;
				if(rx == x && ry == y) {
					return ;
				}
				q.add(new Pair(rx, ry));
			}
		}
	}
}
