import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int r;
	static boolean[] visited;
	static int[] order;
	static int num = 1;
	static List<List<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		order = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		for(int i = 1; i <= n; i++) {
			Collections.sort(adj.get(i));
		}
		
		bfs(r);
		for(int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}
	}
	public static void bfs(int x) {
		visited[x] = true;
		order[x] = num++;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : adj.get(now)) {
				if(visited[next]) continue;
				visited[next] = true;
				order[next] = num++;
				q.add(next);
			}
		}
	}
}