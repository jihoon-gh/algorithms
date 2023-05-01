import java.util.*;

class Solution {
    static HashMap<String, Integer> req = new HashMap<>();
    static HashMap<String, Integer> curr = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < want.length; i++){
            req.put(want[i], number[i]);
        }
        int left = 0;
        int right = 0;
        while(right < discount.length){
            if(right < 10){
                int k = curr.getOrDefault(discount[right], 0);
                curr.put(discount[right], k+1);
                right++;
            }
            else{
                int x = curr.get(discount[left]);
                curr.put(discount[left], x-1);
                left++;
                int y = curr.getOrDefault(discount[right], 0);
                curr.put(discount[right], y + 1);
                right++;
            }
            if(isSame(want)){
                    answer++;
            }
        }
        return answer;
    }
    public static boolean isSame(String[] want){
        for(String w : want){
            if(req.get(w) != curr.getOrDefault(w, 0)){
                return false;
            }
        }
        return true;
    }
}