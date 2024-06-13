
	
	import java.util.*;
	import java.io.*;
	
	public class Main {
		static int n, m;
		static int[] arr;
		static ArrayDeque<Integer> ad = new ArrayDeque<>();
		static Set<List<Integer>> hs = new HashSet<>();
		public static void main(String[] args) throws Exception {
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
			List<List<Integer>> res = new ArrayList<>();
			for(List<Integer> tmp : hs) {
				res.add(tmp);
			}
			Collections.sort(res, new Comparator<>() {
				@Override
				public int compare(List<Integer> l1, List<Integer> l2) {
					for(int i = 0; i < m ; i++) {
						if(l1.get(i) == l2.get(i)) continue;
						return l1.get(i) - l2.get(i);
					}
					return -1;
				}
			});
			for(List<Integer> ls : res) {
				for(int i : ls) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		public static void dfs(int i) {
			if(ad.size() == m) {
				List<Integer> tmp = new ArrayList<>();
				for(int x : ad) {
					tmp.add(x);
				}
				hs.add(tmp);
			}
			else {
				for(int j = i + 1; j < n; j++) {
					ad.addLast(arr[j]);
					dfs(j);
					ad.pollLast();
				}
			}
		}
	}
	
