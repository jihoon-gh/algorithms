import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static int n;
	static List<List<Integer>> adj = new ArrayList<>();
	static int leaf = 0;
	static boolean[] isRemoved;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		isRemoved = new boolean[n];
		for(int i = 0; i <= n - 1; i++) {
			List<Integer> nums = new ArrayList<>();
			adj.add(nums);
		}
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = i;
				continue;
			}
			adj.get(parent).add(i);
		}
		
		int rid = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			if(adj.get(i).contains(rid)) {
				int k = adj.get(i).indexOf(rid);
				adj.get(i).remove(k);
			}
		}
		removeNodes(rid);
		dfs(root);
		System.out.println(leaf);
	}
	public static void removeNodes(int x) {
		if(isRemoved[x]) return;
		isRemoved[x] = true;
		for(int next : adj.get(x)) {
			removeNodes(next);
		}
	}
	
	public static void dfs(int x) {
		if(adj.get(x).size() == 0 && !isRemoved[x]) {
			leaf++;
			return ;
		}
		for(int i : adj.get(x)) {
			dfs(i);
		}
	}
}
