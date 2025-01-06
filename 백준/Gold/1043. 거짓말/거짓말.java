import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] link;
	static int[] size;
	static Set<Integer> truthKeepers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		link = new int[n + 1];
		size = new int[n + 1];
		init();
		size[0] = 10;
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		truthKeepers = new HashSet<>();
		if(k != 0) {
			for(int i = 0; i < k; i++) {
				int x = Integer.parseInt(st.nextToken());
				unite(0, x);
				truthKeepers.add(x);
			}
		}
		
		List<Set<Integer>> party = new ArrayList<>();
		for(int i= 0; i < m; i++) {
			Set<Integer> tmp = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			party.add(tmp);
		}
		
		for(int i = 0; i < m; i++) {
			for(Set<Integer> tmp : party) {
				int person = -1;
				for(int t : truthKeepers) {
					if(tmp.contains(t)) {
						person = t;
						break;
					}
				}
				if(person != -1) process(person, tmp);
			}
		}

		int truth = 0;
		for(Set<Integer> tmp : party) {
			for(int p : tmp) {
				if(link[p] == 0) {
					truth++;
					break;
				}
			}
		}
		int ans = m - truth;
		System.out.println(ans);
	}
	
	public static void process(int person, Set<Integer> tmp) {
		for(int t : tmp) {
			if(!same(person, t)) unite(person, t);
			truthKeepers.add(t);
		}
	}
	public static void unite(int a, int b) {
		a = find(a);
		b = find(b);
		if(size[a] < size[b]) {
			int c = a;
			a = b;
			b = c;
		}
		link[b] = a;
		size[a] += size[b];
	}
	public static int find(int x) {
		if(link[x] == x) return x;
		else return link[x] = find(link[x]);
	}
	public static boolean same(int a, int b) {
		return find(a) == find(b); 
	}
	public static void init() {
		for(int i = 0; i <= n; i++) {
			link[i] = i;
			size[i] = 1;
		}
	}
}