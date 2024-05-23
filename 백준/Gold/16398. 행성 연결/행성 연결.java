import java.util.*;
import java.util.stream.Collectors;
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
	static int link[];
	static int size[];
	static List<Edge> edges = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		link = new int[n + 1];
		size = new int[n + 1];
		init(n);
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int d = Integer.parseInt(st.nextToken());
				if(d == 0) continue;
				edges.add(new Edge(i + 1, j + 1, d));
			}
		}
		
		Collections.sort(edges, new Comparator<>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.d - e2.d;
			}
		});
		long ans = 0;
		for(Edge e : edges) {
			int a = e.a;
			int b = e.b;
			if(!isSame(a, b)) {
				unite(a, b);
				ans += e.d;
			}
		}
		System.out.println(ans);
	}
	public static void init(int n) {
		for(int i = 0; i <= n; i++) {
			link[i] = i;
			size[i] = 1;
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
		if(size[a] < size[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		link[b] = a;
		size[a] += size[b];
	}
}
