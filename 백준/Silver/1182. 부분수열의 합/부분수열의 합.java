import java.io.*;
import java.util.*;

public class Main {

	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	static List<Integer> nums = new ArrayList<>();
	static int k = 0;
	static int n;
	static int target;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		for(k = 1; k <= n; k++) {
			for(int i = 0; i < n; i++) {
				dfs(i);
				ad.clear();
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int x) {
		ad.addLast(nums.get(x));
		if(ad.size() == k) {
			int res = getRes();
			if(res == target) {
				ans++;
			}
		}
		else {
			for(int i = x + 1; i < n; i++) {
				dfs(i);
			}
		}
		ad.pollLast();
	}
	public static int getRes() {
		int sum = 0;
		for(int i : ad) {
			sum += i;
		}
		return sum;
	}
}