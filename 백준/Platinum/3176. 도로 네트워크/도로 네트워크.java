import java.io.*;
import java.util.*;

public class Main {

	static class Pair{
		public int next;
		public int weight;
		public Pair(int a ,int b) {
			next = a;
			weight = b;
		}
	}
	
	static int maxNodes = 100000;
	static int maxLevel = (int)Math.floor(Math.log(maxNodes)/Math.log(2));
	static int[] depth = new int[maxNodes+1];
	static int[][] ac = new int[maxNodes+1][maxLevel+1];
	static int[][] distMax = new int[maxNodes+1][maxLevel+1];
	static int[][] distMin = new int[maxNodes+1][maxLevel+1];
	
	
	static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			ArrayList<Pair> temp = new ArrayList<>();
			adj.add(temp);
		}
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj.get(a).add(new Pair(b, w));
			adj.get(b).add(new Pair(a, w));
			
			
		}
		depth[0] = 0;
		bfs();
		makeTree();
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ansMax = 0;
			int ansMin = 1000000001;
			
			if(depth[a]!= depth[b]) {
				if(depth[a] > depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				
				for(int j = maxLevel; j >= 0; j--) {
					if(depth[a] <= depth[ac[b][j]]) {
						ansMax = Math.max(ansMax, distMax[b][j]);
						ansMin = Math.min(ansMin, distMin[b][j]);
						b = ac[b][j];
					}
				}
			}
			if(a == b) {
				System.out.println(ansMin + " " + ansMax);
				continue;
			}
			else {
				for(int j = maxLevel; j >= 0; j--) {
					if(ac[a][j] != ac[b][j]) {
						ansMax = Math.max(ansMax, Math.max(distMax[a][j], distMax[b][j]));
						ansMin = Math.min(ansMin, Math.min(distMin[a][j], distMin[b][j]));
						a = ac[a][j];
						b = ac[b][j];
					}
				}
				ansMax = Math.max(ansMax, Math.max(distMax[a][0], distMax[b][0]));
				ansMin = Math.min(ansMin, Math.min(distMin[a][0], distMin[b][0]));
				System.out.println(ansMin + " " + ansMax);
			}
		}
		
	}
	public static void bfs() {
		depth[1] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Pair p : adj.get(now)) {
				if(depth[p.next] != 0) {
					continue;
				}
				depth[p.next] = depth[now] + 1;
				ac[p.next][0] = now;
				distMax[p.next][0] = p.weight;
				distMin[p.next][0] = p.weight;
				q.add(p.next);
			}
		}
	}
	public static void makeTree() {
		for(int i = 1; i <= maxLevel; i++) {
			for(int j = 1; j <= maxNodes; j++) {
				int tmp = ac[j][i-1];
				ac[j][i] = ac[tmp][i-1];
				distMin[j][i] = Math.min(distMin[j][i-1], distMin[tmp][i-1]);
				distMax[j][i] = Math.max(distMax[j][i-1], distMax[tmp][i-1]);
			}
		}
	}
}
