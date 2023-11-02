import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
		
	static class Truck{
		int weight;
		int dist;
		public Truck(int a, int b) {
			weight = a;
			dist = b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, w, l;
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		Queue<Truck> ready = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			Truck t = new Truck(Integer.parseInt(st.nextToken()), 0);
			ready.add(t);
		}
		int ans = 0;
		int sum = 0;
		Queue<Truck> bridge = new LinkedList<>();
		while(!ready.isEmpty() || !bridge.isEmpty()) {
			ans++;
			if(ready.isEmpty()) {
				for(Truck t : bridge) {
					t.dist++;
				}
				while(!bridge.isEmpty()) {
					if(bridge.peek().dist > w){
						Truck out = bridge.poll();
						sum -= out.weight;
					}
					else {
						break;
					}
				}
				continue;
			}
			if(bridge.isEmpty()) {
				Truck t = ready.poll();
				sum += t.weight;
				t.dist++;
				bridge.add(t);
			}
			else {
				for(Truck t : bridge) {
					t.dist++;
				}
				while(!bridge.isEmpty()) {
					if(bridge.peek().dist > w){
						Truck out = bridge.poll();
						sum -= out.weight;
					}
					else {
						break;
					}
				}
				if(!ready.isEmpty() && l - sum >= ready.peek().weight) {
					Truck t = ready.poll();
					sum += t.weight;
					t.dist++;
					bridge.add(t);
				}
			}
			
		}
		System.out.println(ans);
	}
}
