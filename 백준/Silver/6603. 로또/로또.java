import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static int n;
	static List<Integer> nums;
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			nums = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			dfs(0);
			System.out.println();
		}
	}
	public static void dfs(int x) {
		if(ad.size() == 6) {
			for(int i : ad) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		else {
			for(int i = x; i < nums.size(); i++) {
				ad.add(nums.get(i));
				dfs(i + 1);
				ad.pollLast();
			}
		}
	}
}