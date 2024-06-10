import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	public static class Edge{
		int node1;
		int node2;
		int dist;
		public Edge(int x, int y, int z) {
			node1 = x;
			node2 = y;
			dist = z;
		}
	}
	static int n, m;
	static boolean[] isMale;
	static List<Edge> edges = new ArrayList<>();
	static int[] link;
	static int[] size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		isMale = new boolean[n + 1];
		link = new int[n + 1];
		size = new int[n + 1];
		init();
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			if(st.nextToken().equals("M")) {
				isMale[i] = true;
			}
			else {
				isMale[i] = false;
			}
		}

		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(isMale[a] != isMale[b]) {
				edges.add(new Edge(a, b, d));
			}
		}
		
		Collections.sort(edges, new Comparator<>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.dist - e2.dist;
			}
		});
		
		int ans = 0;
		for(Edge e : edges) {
			if(!isSame(e.node1, e.node2)) {
				unite(e.node1, e.node2);
				ans += e.dist;
			}
		}
		boolean isAns = true;
		int x = find(1);
		for(int i = 1; i <= n; i++) {
			if(x != find(i)) {
				isAns = false;
			}
		}
		if(!isAns) System.out.println(-1);
		else System.out.println(ans);
		
	}
	public static  void init() {
		for(int i = 0; i <= n; i++) {
			link[i] = i;
			size[i] = 1;
		}
	}
	
	public static int find(int x) {
		if(link[x] == x) return x;
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

