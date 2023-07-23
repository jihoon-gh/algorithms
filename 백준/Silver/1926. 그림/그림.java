import java.io.*;
import java.util.*;

public class Main{

	static class Pair{
		public int x;
		public int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	static int[][] arr;
	static boolean[][] visited;
	static List<Pair> plist = new ArrayList<>();
	int ans = 0;
	public static void main(String[] args) throws Exception{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  int n = Integer.parseInt(st.nextToken());
		  int m = Integer.parseInt(st.nextToken());
		  arr = new int[n][m];
		  visited = new boolean[n][m];
		  for(int i = 0; i < n; i++) {
			  st = new StringTokenizer(br.readLine());
			  for(int j = 0; j < m; j++) {
				  arr[i][j] = Integer.parseInt(st.nextToken());
				  if(arr[i][j] == 1) {
					  plist.add(new Pair(i, j));
				  }
			  }
		  }
		  int num = 0;
		  int ans = 0;
		  for(Pair p : plist) {
			  if(visited[p.x][p.y]) continue;
			  num++;
			  ans = Integer.max(ans, bfs(p.x, p.y));
		  }
		  System.out.println(num);
		  System.out.println(ans);
		  
	}
	public static int bfs(int a, int b) {
		int res = 1;
		Queue<Pair> q = new LinkedList<>();
		visited[a][b] = true;
		q.add(new Pair(a, b));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			for(int i = 0; i < 4; i++) {
				int rx = dx[i] + p.x;
				int ry = dy[i] + p.y;
				if(rx < 0 || rx >= arr.length || ry < 0 || ry >= arr[0].length) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				if(arr[rx][ry] == 1) {
					res++;
					q.add(new Pair(rx, ry));
				}
			}
		}
		return res;
	}
}
