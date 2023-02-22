
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int maxNodes = 50000;
	static int maxLevel = (int)Math.floor(Math.log(maxNodes)/Math.log(2));
	static int[][] ac = new int[maxNodes+1][maxLevel+1];
	static int[] depth = new int[maxNodes+1];
	
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			adj.add(temp);
		}
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		depth[0] = -1;
		bfs();
		makeTree();
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(depth[a] != depth[b]) {
				if(depth[a] > depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				
				for(int j = maxLevel; j >= 0; j--) {
					if(depth[a] <= depth[ac[b][j]]) {
						b = ac[b][j];
					}
				}
			}
			int lca = a;
			if( a == b) {
				System.out.println(lca);
				continue;
			}
			if(a != b) {
				for(int j = maxLevel; j >= 0; j--) {
					if(ac[a][j] != ac[b][j]) {
						a = ac[a][j];
						b = ac[b][j];
					}
					lca = ac[a][j];
				}
				System.out.println(lca);
			}
		}
	}
	public static void bfs() {
		depth[1] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adj.get(now)) {
				if(depth[next] != 0) continue;
				depth[next] = depth[now] + 1;
				ac[next][0] = now;
				q.add(next);
			}
		}
	}
	
	public static void makeTree() {
		for(int i = 1; i <= maxLevel; i++) {
			for(int j = 1; j<= maxNodes; j++) {
				int tmp = ac[j][i-1];
				ac[j][i] = ac[tmp][i-1];
			}
		}
	}

}
