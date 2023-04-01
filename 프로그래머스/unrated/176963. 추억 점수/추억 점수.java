import java.util.*;

class Solution {
    static Map<String, Integer> m = new HashMap<>();
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i = 0; i < name.length; i++){
            m.put(name[i], yearning[i]);
        }
        
        int i = 0;
        for(String[] sarr : photo){
            int res = 0;
            for(String s : sarr){
                res += m.getOrDefault(s, 0); 
            }
            answer[i++] = res;
        }
        return answer;
    }
}