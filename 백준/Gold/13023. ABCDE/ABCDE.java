import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int n, m;
	static List<List<Integer>> nums = new ArrayList<>();
	static ArrayDeque<Integer> ad;
	static int ans = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; i++) {
			List<Integer> tmp = new ArrayList<>();
			nums.add(tmp);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			nums.get(a).add(b);
			nums.get(b).add(a);
		}
		for(int i = 1; i <= n; i++) {
			if(ans == 1) break;
			ad = new ArrayDeque<>();
			visited = new boolean[n + 1];
            visited[i] = true;
			dfs(i);
            visited[i] = false;
		}
		System.out.println(ans);
	
	}
	public static void dfs(int now) {
		if(ans == 1) return;
		ad.addLast(now);
		if(ad.size() == 5) {
			ans = 1;
			return;
		}
		for(int next : nums.get(now)) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next);
			visited[next] = false;
		}
		ad.removeLast();
		
	}
}
