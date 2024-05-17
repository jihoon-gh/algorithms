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
	static int ans = 0;
	static int n, m;
	static List<List<Pair>> adj = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) {
			List<Pair> tmp = new ArrayList<>();
			adj.add(tmp);
		}
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Pair(b, d));
			adj.get(b).add(new Pair(a, d));
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			dfs(start, 0, end, 0);
			System.out.println(ans);
		}
		
	}
	public static void dfs(int now, int before, int end, int dist) {
		if(now == end) {
			ans = dist;
			return;
		}
		else {
			for(Pair next : adj.get(now)) {
				if(next.node == before) continue;
				dfs(next.node, now, end, dist + next.dist);
			}
		}
	}
}
