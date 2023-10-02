import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static class Pair{
		int value;
		int index;
		public Pair(int a, int b) {
			value = a;
			index = b;
		}
	}
	static int num = 0;
	static int ans = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			num -= out;
			num += in;
			ans = Math.max(num, ans);
		}
		System.out.println(ans);
	}
}
