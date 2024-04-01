import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int r;
	static int c;
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int ans = 0;
	static List<Integer> ansList = new ArrayList<>();
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x1, y1, x2, y2;
			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			for(int k = x1; k < x2; k++) {
				for(int j = y1; j < y2; j++) {
					arr[k][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] == 1) continue;
				if(visited[i][j]) continue;
				bfs(i, j);
			}
		}
		
		Collections.sort(ansList);
		System.out.println(ansList.size());
		for(int i : ansList) {
			System.out.print(i + " ");
		}
	}
	public static void bfs(int x, int y) {
		int ans = 1;
		visited[x][y] = true;
		Pair p = new Pair(x, y);
		Queue<Pair> q = new LinkedList<>();
		q.add(p);
		while(!q.isEmpty()) {
			Pair now = q.poll();
			int[] dx = {0, 0, 1, -1};
			int[] dy = {1, -1, 0, 0};
			for(int i = 0; i < 4; i++) {
				int rx = now.x + dx[i];
				int ry = now.y + dy[i];
				if(rx < 0 || rx >= r || ry < 0 || ry >= c) continue;
				if(arr[rx][ry] == 1) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				ans++;
				q.add(new Pair(rx, ry));
			}
		}
		ansList.add(ans);
	}
}
