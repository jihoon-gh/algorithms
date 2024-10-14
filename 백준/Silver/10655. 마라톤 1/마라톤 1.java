import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static class Pair{
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		List<Pair> pairs = new ArrayList<>();
		int ans = 987654321;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pairs.add(new Pair(a, b));
		}
		
		int totalDist = 0;
		for(int i = 1 ; i < n; i++) {
			Pair before = pairs.get(i - 1);
			Pair now = pairs.get(i);
			int tmp = getDist(now, before);
			totalDist += tmp;
		}
		
		for(int i = 1; i < n - 1; i++) {
			Pair before = pairs.get(i - 1);
			Pair now = pairs.get(i);
			Pair after = pairs.get(i + 1);
			int res = totalDist - getDist(now, before) - getDist(after, now) + getDist(after, before);
			ans = Math.min(ans, res);
		}
		System.out.println(ans);
	}
	public static int getDist(Pair p1, Pair p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}