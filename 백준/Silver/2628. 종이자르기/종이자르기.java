import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static List<Integer> xlist = new ArrayList<>();
	static List<Integer> ylist = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		xlist.add(0);
		xlist.add(m);
		ylist.add(0);
		ylist.add(n);
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x == 0) {
				xlist.add(y);
			}
			else {
				ylist.add(y);
			}
		}
		Collections.sort(xlist);
		Collections.sort(ylist);
		int a = 0;
		for(int i = 1; i < xlist.size(); i++) {
			a = Math.max(a, xlist.get(i) - xlist.get(i - 1));
		}
		int b = 0;
		for(int i = 1; i < ylist.size(); i++) {
			b = Math.max(b, ylist.get(i) - ylist.get(i - 1));
		}
		System.out.println(a * b);
			
	}
}
