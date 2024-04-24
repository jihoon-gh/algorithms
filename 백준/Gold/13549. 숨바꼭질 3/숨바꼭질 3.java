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
	
	static List<List<Pair>> adj = new ArrayList<>();
	static int[] dist = new int[100001];
	static boolean[] visited = new boolean[100001];
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 init();
		 dijkstra();
		 System.out.println(dist[m]);
	}
	public static void init() {
		for(int i = 0; i <= 100000; i++) {
			List<Pair> tmp = new ArrayList<>();
			if(i == 0) {
				tmp.add(new Pair(i + 1, 1));
			}
			else {
				tmp.add(new Pair(i + 1, 1));
				tmp.add(new Pair(i - 1, 1));
				tmp.add(new Pair(i * 2, 0));
			}
			adj.add(tmp);
			dist[i] = 987654321;
			visited[i] = false;
		}
	}
	public static void dijkstra() {
		dist[n] = 0;
		PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.dist - p2.dist;
			}
		});
		q.add(new Pair(n, 0));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			if(visited[now.node]) continue;
			visited[now.node] = true;
			for(Pair next : adj.get(now.node)) {
				if(next.node < 0 || next.node > 100000) continue;
				if(dist[next.node] > dist[now.node] + next.dist) {
					dist[next.node] = dist[now.node] + next.dist;
					q.add(new Pair(next.node, dist[next.node]));
				}
			}
		}
	}
}
