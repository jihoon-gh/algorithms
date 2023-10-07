import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static class Pair{
		int x;
		int y;
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	static List<Pair> plist = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			plist.add(new Pair(start, end));
		}
		Collections.sort(plist, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.x == p2.x) {
					return p1.y - p2.y;
				}
				return p1.x - p2.x;
			}
		});
		
		for(Pair p : plist) {
			if(pq.isEmpty()) {
				pq.add(p.y);
				continue;
			}
			if(pq.peek() <= p.x) {
				pq.poll();
			}
			pq.add(p.y);
		}
		System.out.println(pq.size());
	}
}
