import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static int[][] arr;
	static int[][] dist;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int min;
	static int n;
	static int res;
	static int t = 1;
	static class Pair {
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			min = 987654321;
			res = 0;
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			arr = new int[n][n];
			dist = new int[n][n];
			init();
			StringTokenizer st;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(0, 0);
			System.out.println("Problem "+ t +": "+  dist[n - 1][n - 1]);
			t++;
		}
	}
	public static void init() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dist[i][j] = -1;
			}
		}
	}
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		dist[x][y] = arr[x][y];
		while(!q.isEmpty()) {
			Pair node = q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = node.x + dx[i];
				int ry = node.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;
				if(dist[rx][ry] == -1 || dist[node.x][node.y] + arr[rx][ry] < dist[rx][ry]) {
					dist[rx][ry] = dist[node.x][node.y] + arr[rx][ry]; 
					q.add(new Pair(rx, ry));
				}
			}
		}
	}
}