import java.util.*;

class Solution {
    public int[] solution(long n) {
        String[] splits = Long.toString(n).split("");
        int[] answer = new int[splits.length];
        List<String> s = Arrays.asList(splits);
        Collections.reverse(s);
        for(int i = 0; i < s.size(); i++){
            answer[i]  = Integer.parseInt(s.get(i));
        }
        return answer;
    }
}