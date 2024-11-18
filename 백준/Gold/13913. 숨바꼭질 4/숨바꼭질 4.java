import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
	static int[] dist;
	static int[] parent;
	static int x, y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dist = new int[200001];
		parent = new int[200001];
		visited = new boolean[200001];
		bfs();
		Stack<Integer> stack = new Stack<>();
		int tmp = y;
		while(tmp != -1) {
			stack.add(tmp);
			tmp = parent[tmp];
		}
		System.out.println(dist[y]);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	public static void bfs() {
		dist[x] = 0;
		visited[x] = true;
		parent[x] = -1;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 0; i < 3; i++) {
				int next = edit(now, i);
				if(next >= dist.length || next < 0) continue;
				if(visited[next]) continue;
				visited[next] = true;
				dist[next] = dist[now] + 1;
				parent[next] = now;
				if(next == y) return;
				q.add(next);
			}
		}
	}
	public static int edit(int a, int i) {
		if(i == 0) return a * 2;
		if(i == 1) return a + 1;
		return a - 1;
	}
}