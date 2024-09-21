import java.util.*;
import java.io.*;

public class Main {
    
	static class Pair{
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		int xStart = 0;
		int yStart = 0;
		
		for(int i = 0; i < n; i++) {
			String[] splits = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				if(splits[j].equals("O")) arr[i][j] = 0;
				if(splits[j].equals("X")) arr[i][j] = -1;
				if(splits[j].equals("P")) arr[i][j] = 1;
				if(splits[j].equals("I")) {
					xStart = i;
					yStart = j;
				}
			}
		}
		init();
		bfs(xStart, yStart);
		if(ans == 0) {
			System.out.println("TT");
			return ;
		}
		System.out.println(ans);
	}
	public static void init() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = false;
			}
		}
	}
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = now.x + dx[i];
				int ry = now.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
				if(arr[rx][ry] == -1) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				if(arr[rx][ry] == 1) ans++;
				q.add(new Pair(rx, ry));
			}
		}
	}
}

