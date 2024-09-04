import java.util.*;
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
	static List<List<Pair>> adj = new ArrayList<>();
	static int n, dest;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		dist = new int[dest + 1];
		visited = new boolean[dest + 1];
		for(int i = 0; i <= dest; i++) {
			List<Pair> tmp = new ArrayList<>();
			adj.add(tmp);
			adj.get(i).add(new Pair(i + 1, 1));
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(end > dest || start > dest) continue;
			int d = Integer.parseInt(st.nextToken());
			if(end - start > d) adj.get(start).add(new Pair(end, d));
		}
		init();
		dijkstra();
		System.out.println(dist[dest]);
	}
	public static void init() {
		for(int i = 0; i <= dest; i++) {
			dist[i] = 987654321;
			visited[i] = false;
		}
	}
	public static void dijkstra() {
		dist[0] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.dist - p2.dist;
			}
		});
		pq.add(new Pair(0, dist[0]));
		while(!pq.isEmpty()) {
			Pair now = pq.poll();
			if(visited[now.node]) continue;
			visited[now.node] = true;
			for(Pair next : adj.get(now.node)) {
				if(next.node > dest) continue;
				if(dist[next.node] > dist[now.node] + next.dist) {
					dist[next.node] = dist[now.node] + next.dist;
					pq.add(new Pair(next.node, dist[next.node]));
				}
			}
		}
	}
	
}

