import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static class Taste{
		int sourness;
		int bitterness;
		public Taste(int a, int b) {
			sourness = a;
			bitterness = b;
		}
	}
	static List<Taste> tastes = new ArrayList<>();
	static int n;
	static int s = 1;
	static int b = 0;
	static int res = 2000000000;
	static int ans = 2000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Taste t = new Taste(a, b);
			tastes.add(t);
		}
		for(int i = 0; i < n; i++) {
			res = 2000000000;
			dfs(i);
		}
		System.out.println(ans);
	}
	public static void dfs(int x) {
		//골랐을 때와 고르지 않았을 때
		if(x >= n) return;
		Taste t = tastes.get(x);
		int ns = s;
		int nb = b;
		s = s * t.sourness;
		b = b + t.bitterness;
		res = Math.min(res, Math.abs(s - b));
		ans = Math.min(ans, res);
		for(int i = x + 1; i < n; i++) {
			dfs(i);
		}
		s = ns;
		b = nb;
		for(int i = x + 1; i < n; i++) {
			dfs(i);
		}
	}
}

