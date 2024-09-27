import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] dp1;
	static int[] dp2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp1 = new int[n];
		dp2 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp1[0] = 1;
		dp2[0] = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i - 1] <= arr[i]) {
				dp1[i] = dp1[i - 1] + 1;
			}
			else {
				dp1[i] = 1;
			}
			if(arr[i - 1] >= arr[i]) {
				dp2[i] = dp2[i - 1] + 1;
			}
			else {
				dp2[i] = 1;
			}
		}
		int res1 = Arrays.stream(dp1).max().getAsInt();
		int res2 = Arrays.stream(dp2).max().getAsInt();
		System.out.println(Math.max(res1,  res2));
	}
}

