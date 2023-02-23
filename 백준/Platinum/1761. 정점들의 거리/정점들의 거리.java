
import java.util.*;
import java.io.*;

public class Main {

	static class Pair{
		public int next;
		public int weight;
		public Pair(int a, int b) {
			next = a;
			weight = b;
		}
	}
	static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	static int maxNodes = 40000;
	static int maxLevel = (int)Math.floor(Math.log(maxNodes)/Math.log(2));
	static int[][] ac = new int[maxNodes+1][maxLevel+1];
	static int[][] dist = new int[maxNodes+1][maxLevel+1];
	static int[] depth = new int[maxNodes+1];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			ArrayList<Pair> temp = new ArrayList<>();
			adj.add(temp);
		}
		
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj.get(a).add(new Pair(b, w));
			adj.get(b).add(new Pair(a, w));
		}
		depth[0] = -1;
		bfs(1);
		makeTree();
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distB = 0;
			int distA = 0;
			
			if(depth[a] != depth[b]) {
				if(depth[a] > depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				
				for(int j = maxLevel; j >= 0; j--) {
					if(depth[a] <= depth[ac[b][j]]) {
						distB += dist[b][j];
						b = ac[b][j];
					}
				}
			}
			int lca = a;
			if( a == b) {
				System.out.println(distB + distA);
				continue;
			}
			else {
				for(int j = maxLevel; j >= 0; j--) {
					if(ac[a][j] != ac[b][j]) {
						distA += dist[a][j];
						distB += dist[b][j];
						a = ac[a][j];
						b = ac[b][j];
					}
					lca = ac[a][j];
				}
				distA += dist[a][0];
				distB += dist[b][0];
				System.out.println(distA + distB);
			}
		}
	}
	public static void bfs(int start) {
		depth[start] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Pair p : adj.get(now)) {
				if(depth[p.next] != 0) continue;
				depth[p.next] = depth[now] + 1;
				ac[p.next][0] = now;
				dist[p.next][0] = p.weight;
				q.add(p.next);
			}
		}
	}
	
	public static void makeTree() {
		
		for(int i = 1; i <= maxLevel; i++) {
			for(int j = 1; j <= maxNodes; j++) {
				int tmp = ac[j][i-1];
				ac[j][i] = ac[tmp][i-1];
				dist[j][i] += dist[tmp][i-1] + dist[j][i-1];
			}	
		}
	}
}
