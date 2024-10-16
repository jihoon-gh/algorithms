import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			long x = Long.parseLong(br.readLine());
			pq.add(x);
		}
		long num = 0;
		while(pq.size() > 1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();
			
			num += (tmp1 + tmp2);
			pq.add(tmp1 + tmp2);
		}
		System.out.println(num);
	}
}