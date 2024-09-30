import java.util.*;
import java.io.*;

public class Main {
	static class Pair{
		int val;
		int idx;
		public Pair(int a, int b) {
			val = a;
			idx = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Pair> st = new Stack<>();
		int[] ans = new int[n];
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(s.nextToken());
			while(!st.isEmpty() && st.peek().val < k) {
				Pair tmp = st.pop();
				ans[tmp.idx] = st.isEmpty() ? 0 : st.peek().idx + 1;
			}
			st.add(new Pair(k, i));
		}
		List<Pair> plist = new ArrayList<>();
		while(!st.isEmpty()) {
			plist.add(st.pop());
		}
		for(int i = 0; i < plist.size() - 1; i++) {
			Pair now = plist.get(i);
			Pair next = plist.get(i + 1);
			ans[now.idx] = next.idx + 1;
		}
		for(int num : ans) {
			System.out.print(num + " ");
		}
	}
}

