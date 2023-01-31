import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[s.length()];
        Map<String, Integer> m  = new HashMap<>();
        String[] splits = s.split("");
        for(int i = 0; i < splits.length; i++){
            int temp = m.getOrDefault(splits[i], -1);
            if(temp != -1){
                arr[i] = i - temp;
            }
            else arr[i] = -1;
            m.put(splits[i], i);
        }
        return arr;
    }
}