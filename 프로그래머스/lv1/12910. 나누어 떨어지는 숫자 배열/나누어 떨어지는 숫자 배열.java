import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> nums = new ArrayList<>();
        for(int i : arr){
            if(i % divisor == 0){
                nums.add(i);
            }
        }
        if(nums.isEmpty()){
            nums.add(-1);
        }
        Collections.sort(nums);
        int[] answer = nums.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}