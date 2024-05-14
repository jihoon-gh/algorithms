import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static int start;
	static int end;
	static boolean isOk = false;
	static boolean[] visited;
	static List<List<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		for(int i = 0; i <= 25; i++) {
			List<Integer> tmp = new ArrayList<>();
			adj.add(tmp);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'a';
			String x = st.nextToken();
			int b = st.nextToken().charAt(0) - 'a';
			adj.get(a).add(b);
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			visited = new boolean[26];
			isOk = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = st.nextToken().charAt(0) - 'a';
			String x = st.nextToken();
			end = st.nextToken().charAt(0) - 'a';
			dfs(start, end);
			if(isOk) {
				System.out.println("T");
			}
			else {
				System.out.println("F");
			}
		}
	}
	public static void dfs(int x, int y) {
		if(x == y) {
			isOk = true;
			return ;
		}
		else {
			for(int next : adj.get(x)) {
				if(visited[next]) continue;
				visited[next] = true;
				dfs(next, y);
				visited[next] = false;
			}
		}
	}
}
