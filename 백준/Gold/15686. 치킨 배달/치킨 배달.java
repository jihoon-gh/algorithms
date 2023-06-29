import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	 
	static class Point{
		public int a;
		public int b;
		public Point(int x, int y) {
			a = x;
			b = y;
		}
	}
	static Deque<Point> dq = new LinkedList<>();
	static int[][] arr;
	static int size;
	static List<Point> homeList = new ArrayList<>();
	static List<Point> chickenList = new ArrayList<>();
	static int[][] dist;
	static int[] dist1;
	static int n, k;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for(int i  = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					homeList.add(new Point(i, j));
				}
				if(arr[i][j] == 2) {
					chickenList.add(new Point(i, j));
				}
			}
		}
		dist = new int[homeList.size()][chickenList.size()];
		dist1 = new int[homeList.size()];
		for(int i = 0; i < homeList.size(); i++) {
			for(int j = 0; j < chickenList.size(); j++) {
				int a = homeList.get(i).a;
				int b = homeList.get(i).b;
				
				int x = chickenList.get(j).a;
				int y = chickenList.get(j).b;
				
				dist[i][j] = Math.abs(a - x) + Math.abs(b - y);
			}
		}
		
		for(int i = 1; i <= Math.min(k,  chickenList.size()); i++) {
			size = i;
			dfs(0);
			dq.clear();
		}
		System.out.println(ans);
		
	}
	public static void dfs(int i) {
		if(dq.size() == size) {
			initDist();
			int res = 0;
			for(Point x : dq) {
				calculateDist(x);
			}
			res = getDistSum();
			ans = Math.min(ans, res);
		}
		else {
			for(int j = i; j < chickenList.size(); j++) {
				dq.addLast(chickenList.get(j));
				dfs(j+1);
				dq.pollLast();
			}
		}
	}
	public static void calculateDist(Point x) {
		int res = 0;
		for(int i = 0; i < homeList.size(); i++) {
			Point p = homeList.get(i);
			res = Math.abs(p.a - x.a) + Math.abs(p.b - x.b);
			if(dist1[i] == 0) {
				dist1[i] = res;
			}
			else {
				dist1[i] = Math.min(dist1[i], res);
			}
		}
	}
	public static int getDistSum() {
		int res = 0;
		for(int d : dist1) {
			res += d;
		}
		return res;
	}
	
	public static void initDist() {
		for(int i = 0; i < dist1.length; i++) {
			dist1[i] = 0;
		}
	}
}
