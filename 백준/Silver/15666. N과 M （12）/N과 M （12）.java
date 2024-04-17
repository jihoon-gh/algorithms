import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	static Set<List<Integer>> hs = new HashSet<>();
	static int n;
	static int m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			dfs(i);
		}
		List<List<Integer>> ans = new ArrayList<>();
		for(List<Integer> tmp : hs) {
			ans.add(tmp);
		}
		Collections.sort(ans, new Comparator<>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				for(int i = 0; i < m; i++) {
					int i1 = l1.get(i);
					int i2 = l2.get(i);
					if(i1 == i2) continue;
					return i1 - i2;
				}
				return -1;
			}
		});
		for(List<Integer> tmp : ans) {
			for(int i : tmp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void dfs(int k) {
		if(ad.size() == m) {
			List<Integer> tmp = new ArrayList<>();
			for(int i : ad) {
				tmp.add(i);
			}
			hs.add(tmp);
		}
		else {
			for(int i = k; i < n; i++) {
				ad.addLast(arr[i]);
				dfs(i);
				ad.removeLast();
			}
		}
	}
}
