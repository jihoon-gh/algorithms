import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static int n, m;
	static List<List<Integer>> adj;
	static boolean[] visited;
	static int[] dist;
	static int[] res;
	static int min = 987654321;
	static int minIdx = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new int[n + 1];
		res = new int[n + 1];
		visited = new boolean[n + 1];
		adj = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			List<Integer> tmp = new ArrayList<>();
			adj.add(tmp);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		for(int i = 1; i <= n; i++) {
			init();
			bfs(i);
			res[i] = getRes();
			if(res[i] < min) {
				min = res[i];
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}
	public static void init() {
		for(int i = 0; i <= n; i++) {
			visited[i] = false;
			dist[i] = 0;
		}
	}
	public static int getRes() {
		int res = 0;
		for(int i = 1; i <= n; i++) {
			res += dist[i];
		}
		return res;
	}
	public static void bfs(int x) {
		dist[x] = 0;
		visited[x] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : adj.get(now)) {
				if(visited[next]) continue;
				visited[next] = true;
				dist[next] = dist[now] + 1;
				q.add(next);
			}
		}
	}
}

