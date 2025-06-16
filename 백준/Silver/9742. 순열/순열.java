import java.util.*;
import java.io.*;

public class Main {
	static int[] factorial = new int[11];
//	static List<String> permutations;
	static char[] arr;
	static boolean[] visited;
	static Deque<Character> ad;
	static StringBuilder sb;
	static int len;
	static int count;
	static String res;
	public static void main(String[] args) throws Exception {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			count = 0;
			String[] splits = input.split(" ");
			String s = splits[0];
			len = s.length();
			visited = new boolean[len];
			int n = Integer.parseInt(splits[1]);
			if(factorial[len] < n) {
				printAnswer(s, n, "No permutation");
				continue;
			}
			arr = s.toCharArray();
//			permutations = new ArrayList<>();
			ad = new ArrayDeque<>();
			for(int i = 0; i < s.length(); i++) {
				doPermutation(i, n);
			}
//			String ans = permutations.get(n - 1);
			printAnswer(s, n, res);
		}
	}
	public static void printAnswer(String s, int n, String ans) {
		System.out.println(s + " " + n + " = " + ans);
	}
	public static void init() {
		factorial[1] = 1;
		for(int i = 2; i <= 10; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
	}
	public static void doPermutation(int x, int target) {
		if(visited[x]) return ;
		visited[x] = true;
		ad.addLast(arr[x]);
		if(ad.size() == len) {
			count++;
			if(count == target) {
				StringBuilder sb = new StringBuilder();
				for(char c : ad) {
					sb.append(c);
				}
				res = sb.toString();
			}
		}
		for(int i = 0; i < len; i++) {
			doPermutation(i, target);
		}
		ad.pollLast();
		visited[x] = false;
	}
}