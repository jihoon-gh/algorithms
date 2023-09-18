import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	static Map<Integer, int[]> hm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] entry = new int[n + 1];
			int[] count = new int[n + 1];
			hm = new HashMap<>();
			for(int i = 1; i <= m; i++) {
				StringTokenizer tmp = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tmp.nextToken());
				int b = Integer.parseInt(tmp.nextToken());
				int c = Integer.parseInt(tmp.nextToken());
				count[a]++;
				entry[a] = i;
				
				if(hm.get(a) == null) {
					hm.put(a, new int[k + 1]);
				}
				
				hm.get(a)[b] = Math.max(hm.get(a)[b], c);
			}
			
			List<Integer> teams = hm.keySet()
					.stream()
					.sorted(new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b){
					if(getScore(a) == getScore(b)) {
						if(count[a] == count[b]) {
							return entry[a] - entry[b];
						}
						else {
							return count[a] - count[b];
						}
					}
					else {
						return getScore(b) - getScore(a);
					}
				}
			}).collect(Collectors.toList());
			for(int i = 0; i < n; i++) {
				if(teams.get(i) == id) {
					System.out.println(i + 1);
				}
			}
		}
	}
	public static int getScore(int a) {
		int[] arr = hm.get(a);
		int score = 0;
		for(int i : arr) {
			score += i;
		}
		return score;
	}
}
