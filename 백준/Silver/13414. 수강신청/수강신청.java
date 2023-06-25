import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> hm = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			hm.put(s, i + 1);
		}
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(String s1, String s2) {
				return hm.get(s1) - hm.get(s2);
			}
		});
		for(String s : hm.keySet()) {
			pq.add(s);
		}
		if(pq.size() < m) {
			while(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}
			return ;
		}
		for(int i = 0; i < m; i++) {
			System.out.println(pq.poll());
		}
		

	}
}
