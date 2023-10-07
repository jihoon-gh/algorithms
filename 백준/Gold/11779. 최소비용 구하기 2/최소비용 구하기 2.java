import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static class Pair{
		int node;
		int dist;
		public Pair(int a, int b) {
			node = a;
			dist = b;
		}
	}
	static int[] dist;
	static boolean[] visited;
	static int n;
	static List<List<Pair>> adj = new ArrayList<>();
	static List<List<Integer>> routes = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			List<Pair> tmp = new ArrayList<>();
			List<Integer> nodes = new ArrayList<>();
			nodes.add(i);
			adj.add(tmp);
			routes.add(nodes);
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adj.get(from).add(new Pair(to, dist));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		init();
		dijkstra(start);
		System.out.println(dist[end]);
		System.out.println(routes.get(end).size());
		for(int i : routes.get(end)) {
			System.out.print(i + " ");
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
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.dist - p2.dist;
			}
		});
		pq.add(new Pair(start, 0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(visited[p.node]) continue;
			visited[p.node] = true;
			for(Pair next : adj.get(p.node)) {
				int b = next.node;
				int d = next.dist;
				if(dist[b] > dist[p.node] + d) {
					dist[b] = dist[p.node] + d;
					routes.get(b).clear();
					for(int i : routes.get(p.node)) {
						routes.get(b).add(i);
					}
					routes.get(b).add(b);
					pq.add(new Pair(b, dist[b]));
				}
			}
		}
	}
	
}
