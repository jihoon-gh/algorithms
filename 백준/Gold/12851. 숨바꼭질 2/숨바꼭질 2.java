import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static int n;
	static int m;
	static int count = 0;
	static boolean[] visited = new boolean[200001];
	static int[] dist = new int[200001];
	static int ans = 1;
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bfs();
		visited[n] = true;
		ad.add(n);
		System.out.println(dist[m]);
		System.out.println(ans);
	}
	public static void bfs() {
		dist[n] = 0;
		visited[n] = true;
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.addLast(n);
		while(!ad.isEmpty()) {
			int now = ad.pollFirst();
			int[] arr = {now * 2, now - 1, now + 1};
			for(int next : arr) {
				if(next < 0 || next > 200000) continue;
				if(visited[next] && next == m && dist[now] + 1 == dist[next]) {
					ans++;
					continue;
				}
				if(visited[next] && dist[now] >= dist[next]) continue;
				visited[next] = true;
				dist[next] = dist[now] + 1;
				if(next == m) {
					ans = 1;
				}
				ad.addLast(next);
			}
		}
	}
}
