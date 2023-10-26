import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
		

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		
		if(2 * k > c) {
			ans += Math.min(x, y) * c;
			long r = Math.max(x,  y) - Math.min(x, y);
			if(k > c && r % 2 == 0) {
				ans += r * c;
			}
			else if(k > c && r % 2 != 0) {
				ans += (r - 1) * c + k;
			}
			else {
				ans += k * r;
			}
			
		}
		else {
			ans = (x + y) * k;
		}
		
		System.out.println(ans);
		
	}
}
