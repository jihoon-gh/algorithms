import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static boolean[][] sky;
	static int k;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] cx = {1, 1, -1, -1};
	static int[] cy = {-1, 1, -1, 1};
	static class Point{
		public int x;
		public int y;
		public Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	static ArrayList<Point> cloud = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		sky = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		init(n);
		
//		System.out.println("----- cloud Start -----");
//		for(Point p : cloud) {
//			System.out.println(p.x + " " + p.y);
//		}	
//		System.out.println("----- cloud End -----");
		
		for(int i = 0; i < m; i++) {
//			printArr();
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			process(d, s);
			
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result += arr[i][j];
			}
		}
		System.out.println(result);
	}
		
//	public static void printArr() {
//		System.out.println("----------------------");
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------------------");
//	}
	public static void init(int n) {
		cloud.add(new Point(n-1, 0));
		cloud.add(new Point(n-1, 1));
		cloud.add(new Point(n-2, 0));
		cloud.add(new Point(n-2, 1));
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sky[i][j] = false;
			}
		}
	}
	public static void process(int d, int s) {
		moveCloud(d, s);
		rain();
		copyWater();
		cloud.clear();
		makeCloud();
	}
	public static void moveCloud(int d, int s) {
		d = d - 1;
		ArrayList<Point> temp = new ArrayList<>();
		for(Point p : cloud) {
			int rx = (p.x + dx[d] * s + n * 100) % n;
			int ry = (p.y + dy[d] * s + n * 100) % n;
			Point nk = new Point(rx, ry);
			temp.add(nk);
		}
		cloud = temp;
		
//		System.out.println("----- cloud Start -----");
//		for(Point p : cloud) {
//			System.out.println(p.x + " " + p.y);
//		}	
//		System.out.println("----- cloud End -----");
		
		for(Point p : cloud) {
			sky[p.x][p.y] = true;
		}
	}
	public static void rain() {
		for(Point p : cloud) {
			int x = p.x;
			int y = p.y;
			arr[x][y]++;
		}
	}
	public static void copyWater() {
		for(Point p : cloud) {
			for(int i = 0; i < 4; i++) {
				int x = p.x + cx[i];
				int y = p.y + cy[i];
				if(x < 0 || x >= n || y < 0 || y >= n) {
					continue;
				}
				if(arr[x][y] > 0) {
					arr[p.x][p.y]++;
				}
			}
		}
	}
	public static void makeCloud() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] >= 2 && !sky[i][j]) {
					arr[i][j] -= 2;
					cloud.add(new Point(i, j));
				}
				sky[i][j] = false;
			}
		}
	}
}