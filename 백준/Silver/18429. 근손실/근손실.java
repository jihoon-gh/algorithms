import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static int n;
	static int k;
	static int[] arr;
	static boolean[] visited;
	static int w = 0;
	static int size = 0;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs();
		System.out.println(ans);
	}
	public static void dfs() {
		if(size == n) {
			ans++;
			return ;
		}
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			if(w + arr[i] - k < 0) continue;
			visited[i] = true;
			size++;
			w = w + arr[i] - k;
			dfs();
			w = w + k - arr[i];
			size--;
			visited[i] = false;
		}
	}
}

