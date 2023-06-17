import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	static class Point{
		int x;
		int y;
		public Point(int a ,int b) {
			x = a;
			y = b;
		}
	}
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dist;
	static int sx, sy; //starting point
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		bfs(sx, sy);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {
					dist[i][j] = 0;
				}
				if(arr[i][j] != 0 && !visited[i][j]) {
					dist[i][j] = -1;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void bfs(int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		visited[x][y] = true;
		dist[x][y] = 0;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int a = p.x;
			int b = p.y;
			for(int i = 0; i < 4; i++) {
				int rx = a + dx[i];
				int ry = b + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
				if(visited[rx][ry]) continue;
				if(arr[rx][ry] == 1) {
					visited[rx][ry] = true;
					dist[rx][ry] = dist[a][b] + 1;
					q.add(new Point(rx,ry));
				}
			}
			
		}
	}
}
