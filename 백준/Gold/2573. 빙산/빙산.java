import java.util.*;
import java.util.stream.Collectors;
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
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static List<Pair> icebergs = new ArrayList<>(); 
	static int n, m;
	static int[][] arr;
	static int [][] darr;
	static boolean[][] visited;
	static int total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		darr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) icebergs.add(new Pair(i, j));
			}
		}
		total = icebergs.size();
		int year = 0;
		int k = 0;
		while(true) {
			year++;
			process();
			if(total == 0) {
				System.out.println(0);
				return ;
			}
			for(Pair p : icebergs) {
				if(arr[p.x][p.y] == 0) continue;
				k = bfs(p);
				break;
			}
			if(k == total) {
				init();
				continue;
			}
			else break;
		}
		System.out.println(year);
		
	}
	public static void init() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = false;
				darr[i][j] = 0;
			}
		}
	}
	public static int bfs(Pair p) {
		int res = 1;
		Queue<Pair> q = new LinkedList<>();
		visited[p.x][p.y] = true;
		q.add(p);
		while(!q.isEmpty()) {
			Pair now = q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = now.x + dx[i];
				int ry = now.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
				if(visited[rx][ry]) continue;
				visited[rx][ry] = true;
				if(arr[rx][ry] == 0) continue;
				res++;
				q.add(new Pair(rx, ry));
			}
		}
		return res;
	}
	
	public static void process() {
		getDarr();
		for(Pair p : icebergs) {
			if(arr[p.x][p.y] == 0) continue;
			arr[p.x][p.y] -= darr[p.x][p.y];
			if(arr[p.x][p.y] <= 0) {
				arr[p.x][p.y] = 0;
				total--;
			}
		}
	}
	public static void getDarr() {
		for(Pair p : icebergs) {
			if(arr[p.x][p.y] == 0) continue;
			for(int i = 0; i < 4; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
				if(arr[rx][ry] == 0) darr[p.x][p.y]++;
			}
		}
	}
}
