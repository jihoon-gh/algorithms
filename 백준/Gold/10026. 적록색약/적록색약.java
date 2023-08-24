
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
	static int n;
	static int[][] arr;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static List<Pair> plist1 = new ArrayList<>();
	static List<Pair> plist2 = new ArrayList<>();
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(temp[j] == 'R') {
					arr[i][j] = 1;
				}
				else if(temp[j] == 'G') {
					arr[i][j] = 3;
				}
				else {
					arr[i][j] = 2;
				}
				plist1.add(new Pair(i, j));
				plist2.add(new Pair(i, j));
			}
		}

		int result1 = 0;
		int result2 = 0;
		for(Pair p : plist1) {
			if(visited1[p.x][p.y]) continue;
			bfs1(p.x, p.y);
			result1++;
			
		}
		
		for(Pair p : plist2) {
			if(visited2[p.x][p.y]) continue;
			result2++;
			bfs2(p.x, p.y);
		}
		System.out.println(result1 + " " + result2);
		
	}
	public static void bfs1(int x, int y) {
		visited1[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int a = p.x;
			int b = p.y;
			for(int i = 0; i < 4; i++) {
				int rx = a + dx[i];
				int ry = b + dy[i];
				if(rx < 0 || ry < 0 || rx >= n || ry >= n) continue;
				if(visited1[rx][ry]) continue;
				if(arr[rx][ry] == arr[a][b]) {
					visited1[rx][ry] = true;
					q.add(new Pair(rx, ry));
				}
			}
		}
	}
	public static void bfs2(int x, int y) {
		visited2[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i < 4; i++) {
				int rx = p.x + dx[i];
				int ry = p.y + dy[i];
				if(rx < 0 || rx >= n || ry < 0 || ry >= n) {
					continue;
				}
				if(visited2[rx][ry]) continue;
				if(arr[rx][ry] % 2 == arr[p.x][p.y] % 2) {
					visited2[rx][ry] = true;
					q.add(new Pair(rx, ry));
				}
			}
		}
	}
	
}