
import java.io.*;
import java.util.*;
public class Main {

	static int[] nums;
	static int[] d;
	static int[] indexOrder;
	static int[] tracking;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nums = new int[n+1];
		d = new int[n+1];
		indexOrder =  new int[n+1];
		tracking = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int length = 1;
		d[1] = nums[length];
		indexOrder[1] = 1;
		for(int i = 2; i <= n; i++) {
			int findIndex = binarySearch(d, nums[i], 1, length);
			indexOrder[i] = findIndex;
			if(findIndex > length) {
				length++;
				d[length] = nums[i];
			}else {
				d[findIndex] = nums[i];
			}
		}

		ans = length;
		 for(int i = n ; i >= 1 ; i--) {
		        if(length == indexOrder[i]) {
		            tracking[length] = nums[i];
		            length--;
		        }
		    }
		System.out.println(ans);
		for(int i = 1; i <= ans; i++) {
			System.out.print(tracking[i]+" ");
		}
		
	}
	public static int binarySearch(int[] arr, int target, int left, int right) {
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(d[mid] == target) {
				return mid;
			}
			if(d[mid] < target) {
				left = mid + 1;
				continue;
			}
			if(d[mid] > target) {
				right = mid - 1;
				continue;
			}
		}
		return left;
	}
}
