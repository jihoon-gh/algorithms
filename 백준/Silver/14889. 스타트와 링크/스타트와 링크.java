import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	
	static Set<Set<Integer>> hs = new HashSet<>();
	static Set<Deque<Integer>> dqset = new HashSet<>();
	static Deque<Integer> dq = new LinkedList<>();
	static int n;
	static int[][] arr;
	static boolean[] team;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		team = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++) {
			dfs(i);
		}
		int ans = Integer.MAX_VALUE;
		for(Deque<Integer> tempDq : dqset) {
			Set<Integer> tmp1 = new HashSet<>();
			Set<Integer> tmp2 = new HashSet<>();
			for(int k : tempDq) {
				tmp1.add(k);
			}
			for(int i = 0; i < n; i++) {
				if(tmp1.contains(i)) continue;
				tmp2.add(i);
			}
			int score1 = calculateScore(tmp1);
			int score2 = calculateScore(tmp2);
		
			ans = Math.min(ans, Math.abs(score2-score1));
		}
		System.out.println(ans);
		
	}
	public static void dfs(int k) {
		if(dq.size() == n/2) {		
			Deque<Integer> dq2 = new LinkedList<>();
			for(int i : dq) {
				dq2.add(i);
			}
			dqset.add(dq2);
			return ;
		}
		else {
			for(int i = k; i < n; i++) {
				dq.addLast(i);
				dfs(i+1);
				dq.removeLast();
			
			}
			return ;
		}
	}
	public static int calculateScore(Set<Integer> s) {
		List<Integer> tmpList = new ArrayList<>();
		for(int i : s) {
			tmpList.add(i);
		}
		int res = 0;
		for(int i = 0; i < tmpList.size(); i++) {
			for(int j = 0; j < tmpList.size(); j++) {
				res += arr[tmpList.get(i)][tmpList.get(j)];
			}
		}
		return res;
	}
}
