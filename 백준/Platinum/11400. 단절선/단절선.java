import java.util.*;
import java.util.stream.Collectors;
import java.math.*;
import java.io.*;
			
public class Main {
	
	static class Pair{
		public int x;
		public int y;
		public Pair(int a, int b) {
			x = Math.min(a, b);
			y = Math.max(a, b);
			
		}
		
	}
	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
	static int[] searchOrder;
	static int order = 1;
	static List<Pair> ans = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		searchOrder = new int[n+1];
		for(int i = 0 ; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			nodes.add(temp);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes.get(a).add(b);
			nodes.get(b).add(a);
		}
		
		for(int i = 1; i<= n; i++) {
			if(searchOrder[i] == 0) {
				dfs(i, 0);
			}
		}
		ans = ans.stream().sorted(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.x == p2.x) {
					return p1.y - p2.y;
				}
				else return p1.x - p2.x;
			}
		}).collect(Collectors.toList());
		System.out.println(ans.size());
		for(Pair p : ans) {
			System.out.println(p.x + " " + p.y);
		}
	}
	
	public static int dfs(int now, int parent) {
		searchOrder[now] = order++;
		int ret = searchOrder[now];
		
		for(int next : nodes.get(now)) {
			if(parent == next) {
				continue;
			}
			
			if(searchOrder[next] != 0) {
				ret = Math.min(ret, searchOrder[next]);
				continue;
			}
			int prev = dfs(next, now);
			if(prev > searchOrder[now]) {
				ans.add(new Pair(now, next));
			}
			ret = Math.min(ret, prev);
		}
		return ret;
	}
}