import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static class Pair{
		int x;
		int y;
		public Pair(int a , int b) {
			x = a;
			y = b;
		}
	}
	
	static int l;
	static int r;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static List<Pair> plist = new ArrayList<>();
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isEnd = true;
		int res = 0;
		while(true) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					Pair now = new Pair(i, j);
					if(visited[i][j]) continue;
					int k = bfs(now);
					if(k == 0) continue;
					isEnd = false;
					plist.add(now);
					int sum = 0;
					for(Pair p : plist) {
						sum += arr[p.x][p.y];
					}
					int val = sum / plist.size();
					for(Pair p : plist) {
						arr[p.x][p.y] = val;
					}
					plist.clear();
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					visited[i][j] = false;
				}
			}
			if(isEnd) {
				break;
			}
			res++;
			isEnd = true;
		}
		System.out.println(res);
	}
	public static int bfs(Pair p) {
		visited[p.x][p.y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(p);
		int res = 0;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = x + dx[i];
				int ry = y + dy[i];
				
				if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;
				if(visited[rx][ry]) continue;
				int tmp = Math.abs(arr[x][y] - arr[rx][ry]);
				if(tmp>= l && tmp <= r) {
					visited[rx][ry] = true;
					Pair next = new Pair(rx, ry);
					q.add(next);
					plist.add(next);
					res++;
				}
			}
		}
		return res;
	}
}
