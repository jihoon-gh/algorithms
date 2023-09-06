import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0 && b == 0 && c == 0) {
				break;
			}
			List<Integer> nums = new ArrayList<>();
			nums.add(a);
			nums.add(b);
			nums.add(c);
			Collections.sort(nums);
			a = nums.get(0);
			b = nums.get(1);
			c = nums.get(2);
			if(c >= a + b) {
				System.out.println("Invalid");
				continue;
			}
			if(a == b && b == c) {
				System.out.println("Equilateral");
				continue;
			}
			else if((a == b && b != c) || (b == c && a != c)) {
				System.out.println("Isosceles");
				continue;
			}
			else {
				System.out.println("Scalene");
			}
			
		}
		
	}

}
