import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < numbers.length -1; i++){
            for(int j = i+1; j< numbers.length; j++){
                nums.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = nums
            .stream()
            .sorted()
            .distinct()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}