import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] arr;
	static int[] visited;
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	static Set<List<Integer>> hs = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			ad.addLast(arr[i]);
			dfs(i);
			ad.pollLast();
		}
	}
	public static void dfs(int x) {
		if(ad.size() == m) {
			for(int i : ad) {
				System.out.print(i + " ");
			}
			System.out.println();
			return ;
		}
		for(int i = x + 1; i < n; i++) {
			ad.addLast(arr[i]);
			dfs(i);
			ad.pollLast();
		}
	}
}
