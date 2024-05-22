import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static int MAX_VALUE = 2000000000;
	static class Edge{
		int node;
		int dist;
		public Edge(int a, int b){
			node = a;
			dist = b;
		}
	}
	static boolean[] visited;
	static int[] dist;
	static List<List<Edge>> adj;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n, d, c;
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			dist = new int[n + 1];
			visited = new boolean[n + 1];
			init(n);
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a, b, s;
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				adj.get(b).add(new Edge(a, s));
			}
			dijkstra(c);
			int nums = getNums(n);
			int time = getTime(n);
			System.out.println(nums + " " + time);
		}
	}
	public static void init(int n) {
		adj = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			dist[i] = MAX_VALUE;
			visited[i] = false;
			List<Edge> edge = new ArrayList<>();
			adj.add(edge);
		}
	}
	public static void dijkstra(int x) {
		dist[x] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.dist - e2.dist;
			}
		});
		pq.add(new Edge(x, dist[x]));
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.node]) continue;
			visited[now.node] = true;
			for(Edge next : adj.get(now.node)) {
				if(dist[next.node] > dist[now.node] + next.dist) {
					dist[next.node] = dist[now.node] + next.dist;
					pq.add(new Edge(next.node, dist[next.node]));
				}
			}
		}
	}
	public static int getNums(int n) {
		int res = 0;
		for(int i = 0; i <= n; i++) {
			if(dist[i] != MAX_VALUE) res++;
		}
		return res;
	}
	public static int getTime(int n) {
		int time = 0;
		for(int i = 0; i <= n; i++) {
			if(dist[i] == MAX_VALUE) continue;
			time = Math.max(time, dist[i]);
		}
		return time;
	}
}
