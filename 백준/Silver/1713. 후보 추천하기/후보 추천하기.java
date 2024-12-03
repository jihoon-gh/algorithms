import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] votes = new int[101];
		int[] histories = new int[101];
		List<Integer> nums = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(nums.contains(x)) {
				votes[x]++;
				Collections.sort(nums, new Comparator<>() {
					@Override
					public int compare(Integer i1, Integer i2) {
						if(votes[i1] == votes[i2]) {
							return histories[i2] - histories[i1];
						}
						return votes[i2] - votes[i1]; 
					}
				});
				continue;
			}
			if(nums.size() >= n) {
				int rm = nums.remove(nums.size() - 1);
				votes[rm] = 0;
			}
			votes[x]++;
			histories[x] = i;
			nums.add(x);
			Collections.sort(nums, new Comparator<>() {
				@Override
				public int compare(Integer i1, Integer i2) {
					if(votes[i1] == votes[i2]) {
						return histories[i2] - histories[i1];
					}
					return votes[i2] - votes[i1]; 
				}
			});
		}
		Collections.sort(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}