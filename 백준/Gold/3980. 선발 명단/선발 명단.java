import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	static boolean[] visited = new boolean[11];
	static int[][] arr;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			ans = 0;
			arr = new int[11][11];
			for(int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs();
			System.out.println(ans);
		}
		
	}
	public static void dfs( ) {
		if(ad.size() == 11) {
			int tmp = 0;
			int k = 0;
			for(int i : ad) {
				tmp += arr[k++][i];
			}
			ans = Math.max(ans, tmp);
			return;
		}
		for(int i = 0; i <= 10; i++) {
			if(arr[ad.size()][i] == 0) continue;
			if(visited[i]) continue;
            visited[i] = true;
            ad.addLast(i);
            dfs();
            ad.pollLast();
            visited[i] = false;
		}
	}
}
