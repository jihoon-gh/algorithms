import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static int[] arr;
	static boolean[] visited;
 	static Set<Integer> tmpSet;
 	static Set<Integer> ansSet = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			int k = Integer.parseInt(br.readLine());
			arr[i] = k;
		}
		for(int i = 1; i<= n; i++) {
			visited = new boolean[n + 1];
			tmpSet = new HashSet<>();
			dfs(i);
		}
		for(int i = 1; i <= n; i++) {
			if(i == arr[i]) {
				ansSet.add(i);
			}
		}
		List<Integer> ans = ansSet.stream().sorted().collect(Collectors.toList());
		System.out.println(ans.size());
		for(int i : ans) {
			System.out.println(i);
		}
	}
	public static void dfs(int i) {
		if(visited[arr[i]] == true) {
			for(int k : tmpSet) {
				if(!visited[k]) return;
			}
			for(int k : tmpSet) {
				ansSet.add(k);
			}
			return ;
		}
		else {
			tmpSet.add(i);
			visited[arr[i]] = true;
			dfs(arr[i]);
		}
	}
}
