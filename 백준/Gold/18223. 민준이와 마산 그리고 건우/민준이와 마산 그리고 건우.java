import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static class Pair{
		int node;
		int dist;
		public Pair(int a, int b) {
			node = a;
			dist = b;
		}
	}
	static int n, m, middle;
	static List<List<Pair>> adj = new ArrayList<>();
	static int distToHome = 0;
	static int distToMiddle = 0;
	static int distMiddleToHome = 0;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		middle = Integer.parseInt(st.nextToken());
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Pair(b, d));
			adj.get(b).add(new Pair(a, d));
		}
		
		init();
		dijkstra(1);
		distToHome = dist[n];
		distToMiddle = dist[middle];
		init();
		dijkstra(middle);
		distMiddleToHome = dist[n];
		if(distToHome == distToMiddle + distMiddleToHome) {
			System.out.println("SAVE HIM");
		}
		else {
			System.out.println("GOOD BYE");
		}
		
	}
	public static void init() {
		for(int i = 0; i <= n; i++) {
			dist[i] = 987654321;
			visited[i] = false;
		}
	}
	public static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.dist - p2.dist;
			}
		});
		pq.add(new Pair(start, 0));
		while(!pq.isEmpty()) {
			Pair now = pq.poll();
			if(visited[now.node]) continue;
			visited[now.node] = true;
			for(Pair next : adj.get(now.node)) {
				if(dist[next.node] > dist[now.node] + next.dist) {
					dist[next.node] = dist[now.node] + next.dist;
					pq.add(new Pair(next.node, dist[next.node]));
				}
			}
		}
	}
}

