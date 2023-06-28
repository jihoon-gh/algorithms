import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	 
	static int[] arr;
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int k = Integer.parseInt(st.nextToken());
		 int n = Integer.parseInt(st.nextToken());
		 arr = new int[n + 1];
		
		 List<Integer> nums = new ArrayList<>();
		 for(int i = 0; i < k; i++) {
			 nums.add(Integer.parseInt(br.readLine()));
		 }
		 for(int i = 0; i <= n; i++) {
			 arr[i] = Integer.MAX_VALUE;
		 }
		 
		 arr[0] = 0;
		 
		 for(int i = 1; i <= n; i++) {
			 for(int x : nums) {
				 if(i - x >= 0 && arr[i- x] != Integer.MAX_VALUE) {
					 arr[i] = Math.min(arr[i], arr[i - x] + 1);
				 }
			 }
		 }
		 if(arr[n] == Integer.MAX_VALUE) {
			 arr[n] = -1;
		 }
		 System.out.println(arr[n]);
		 return;
	 }
}
