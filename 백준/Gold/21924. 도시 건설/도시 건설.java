import java.util.*;
import java.io.*;

public class Main {
	
	static class Edge{
		int a;
		int b;
		int d;
		public Edge(int x, int y, int z) {
			a = x;
			b = y;
			d = z;
		}
	}
	static int n, m;
	static List<Edge> edges = new ArrayList<>();
	static int[] link;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		link = new int[n + 1];
		long total = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, d));
			total += d;
		}
		Collections.sort(edges, new Comparator<>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.d - e2.d;
			}
		});
		init();
		long res = 0;
		for(Edge e : edges) {
			if(!isSame(e.a, e.b)) {
				unite(e.a, e.b);
				res += e.d;
			}
		}
		for(int i = 1; i < n; i++) {
			if(!isSame(i, i + 1)) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(total - res);
		
	}
	public static void init() {
		for(int i = 0; i <= n; i++) {
			link[i] = i;
		}
	}
	public static int find(int x) {
		if(x == link[x]) return x;
		else return link[x] = find(link[x]);
	}
	public static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}
	public static void unite(int a, int b) {
		a = find(a);
		b = find(b);
		link[b] = a;
	}
}

