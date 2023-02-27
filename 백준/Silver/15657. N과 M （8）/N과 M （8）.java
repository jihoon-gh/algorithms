
import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayDeque<Integer> res = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		dfs(0, n, m);
		
	}
	public static void dfs(int idx, int n, int m) {
		if(res.size() == m) {
			for(int k : res) {
				System.out.print(k + " ");
			}
			System.out.println();
			return ;
		}
		for(int i = idx; i < n; i++) {
			res.addLast(nums.get(i));
			dfs( i, n, m);
			res.pollLast();
		}
		return ;
	}
}
