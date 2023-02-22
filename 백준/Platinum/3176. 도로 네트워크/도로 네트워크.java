import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Pair{
		public int next;
		public int weight;
		
		public Pair(int a, int b) {
			next = a;
			weight = b;
		}
	}
	
	static int maxNodes = 100000;
	static int maxLevel = (int)Math.floor(Math.log(maxNodes)/Math.log(2));
	
	static int[][] ac = new int[maxNodes+1][maxLevel+1];
	static int[][] minDist = new int[maxNodes+1][maxLevel+1];
	static int[][] maxDist = new int[maxNodes+1][maxLevel+1];
	
	static int[] depth = new int[maxNodes+1];
	
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
		
		depth[0] = -1;
		bfs(1);
		makeTree();
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ansMax = 0;
			int ansMin = 1000001;
			
			if(depth[a] != depth[b]) {
				if(depth[a] > depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				
				for(int j = maxLevel; j>= 0; j--) {
					if(depth[a] <= depth[ac[b][j]]) {
						ansMax = Math.max(ansMax, maxDist[b][j]);
						ansMin = Math.min(ansMin, minDist[b][j]);
						b = ac[b][j];
					}
				}
			}
			if(a == b) {
				System.out.println(ansMin+" "+ansMax);
				continue;
			}
			else {
				for(int j = maxLevel; j >= 0; j--) {
					if(ac[a][j] != ac[b][j]) {
						ansMax = Math.max(ansMax, Math.max(maxDist[a][j], maxDist[b][j]));
						ansMin = Math.min(ansMin, Math.min(minDist[a][j], minDist[b][j]));
						a = ac[a][j];
						b = ac[b][j];
					}
				}
				ansMax = Math.max(ansMax, Math.max(maxDist[a][0], maxDist[b][0]));
				ansMin = Math.min(ansMin, Math.min(minDist[a][0], minDist[b][0]));
				System.out.println(ansMin+" "+ansMax);
				continue;
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
				if(depth[p.next]!=0) continue;
				depth[p.next] = depth[now] + 1;
				ac[p.next][0] = now;
				minDist[p.next][0] = p.weight;
				maxDist[p.next][0] = p.weight;
				q.add(p.next);
			}
		}
	}
	
	public static void makeTree() {
		for(int i = 1; i <= maxLevel; i++) {
			for(int j = 1; j <= maxNodes; j++) {
				int tmp = ac[j][i-1];
				ac[j][i] = ac[tmp][i-1];
				minDist[j][i] = Math.min(minDist[j][i-1], minDist[tmp][i-1]);
				maxDist[j][i] = Math.max(maxDist[j][i-1], maxDist[tmp][i-1]);
			}
		}
	}
}
