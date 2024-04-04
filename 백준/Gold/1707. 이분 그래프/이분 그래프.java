import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static boolean[] visited;
	static int[] arr;
	static List<List<Integer>> edges;
	static boolean ans = true;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			initList(v);
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges.get(a).add(b);
				edges.get(b).add(a);
			}
			for(int i = 1; i <= v; i++) {
				if(arr[i] != 0) continue;
				bfs(i);
				if(!ans) break;
			}
			printAns();
			ans = true;
		}
	}
	public static void printAns() {
		if(ans) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	public static void initList(int n) {
		visited = new boolean[n + 1];
		edges = new ArrayList<>();
		arr = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			List<Integer> tmp = new ArrayList<>();
			edges.add(tmp);
			arr[i] = 0;
		}
	}
	
	public static void bfs(int x) {
		arr[x] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : edges.get(now)) {
				if(arr[next] == 0) {
					if(arr[now] == 1) arr[next] = 2;
					else arr[next] = 1;
					q.add(next);
					continue;
				}
				if(arr[next] == arr[now]) {
					ans = false;
				}
			}
		}
	}
}
