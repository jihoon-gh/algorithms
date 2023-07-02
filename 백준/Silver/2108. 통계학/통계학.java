import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	static int[] arr = new int[8001];
	 public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 List<Integer> nums = new ArrayList<>();
		 int sum = 0;
		 int max = -4001;
		 int min = 4001;
		 List<Integer> freq = new ArrayList<>();
		 for(int i = 0; i < n; i++) {
			 int k = Integer.parseInt(br.readLine());
			 nums.add(k);
			 sum += k;
			 arr[k+4000]++;
			 max = Math.max(max, k);
			 min = Math.min(min, k);
		 }
		 int frequency = 0;
		 for(int i = 0; i <= 8000; i++) {
			 if(arr[i] > frequency) {
				 freq.clear();
				 frequency = arr[i];
				 freq.add(i);
			 }
			 else if(arr[i] == frequency) {
				 freq.add(i);
			 }
		 }
		 double k = sum / (double)n;
		 if(k < 0) {
			 System.out.println((int)Math.ceil(k - 0.5));
		 }
		 else {
			 System.out.println(Math.round(k));
		 }
		 Collections.sort(nums);
		 System.out.println(nums.get(n / 2));
		 if(freq.size() > 1) {
			 System.out.println(freq.get(1) - 4000);
		 }
		 else {
			 System.out.println(freq.get(0) - 4000);
		 }
		 System.out.println(max - min);
		 
	 }
}
