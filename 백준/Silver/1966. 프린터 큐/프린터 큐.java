import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Map<Integer, Integer> hm = new HashMap<>();
			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer i1, Integer i2) {
					return i2 - i1;
				}
			});
			for(int i = 0; i < n; i++) {
				int k =Integer.parseInt(st.nextToken());
				hm.put(i, k);
				pq.add(k);
				q.add(i);
			}
			int count = 0;
			while(!pq.isEmpty()) {
				int k = q.poll();
				if(hm.get(k) == pq.peek()) {
					count++;
					pq.poll();
					if(k == m) {
						System.out.println(count);
						break;
					}
				}else {
					q.add(k);
				}
			}
		}
	}
}
