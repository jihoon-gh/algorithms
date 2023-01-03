import java.util.*;

class Solution {
    
    static int[] nums = new int[10000001];
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for(int i : tangerine){
            nums[i]++;
        }
        Integer[] nums2 = Arrays.stream(nums)
            .boxed()
            .toArray(Integer[]::new);
        Arrays.sort(nums2, Comparator.reverseOrder());
        for(int n : nums2){
            answer++;
            k = k - n;
            if(k<=0) break;
        }
        return answer;
    }
}