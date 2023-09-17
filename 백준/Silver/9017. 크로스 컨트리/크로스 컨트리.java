import java.io.*;
import java.util.*;

public class Main {

	static Map<Integer, List<Integer>> hm;
	static Map<Integer, Integer> countMap;
	static int ans;
	static int ansIdx = 0;
	static List<Integer> nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			hm = new HashMap<>();
			countMap = new HashMap<>();
			nums = new ArrayList<>();
			ans = 987654321;
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int k = Integer.parseInt(st.nextToken());
				nums.add(k);
				int tmp = countMap.getOrDefault(k, 0);
				countMap.put(k, tmp + 1);
			}
			int count = 1;
			for(int x : nums) {
				if(countMap.get(x) < 6) continue;
				if(hm.get(x) == null) {
					hm.put(x , new ArrayList<>());
				}
				hm.get(x).add(count++);
			}
			
			Set<Integer> s = hm.keySet();
			for(int x : s) {
				List<Integer> tmp = hm.get(x);
	
				tmp = tmp.subList(0, 4);
				int res = 0;
				for(int r : tmp) {
					res += r;
				}
				if(ans == res) {
					int a = hm.get(ansIdx).get(4);
					int b = hm.get(x).get(4);
					if(b < a) {
						ansIdx = x;
					}
				}
				else if(ans > res) {
					ans = res;
					ansIdx = x;
				}
			}
			System.out.println(ansIdx);
		}		
	}
}
