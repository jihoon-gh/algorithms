import java.util.*;

class Solution {
    
    static HashMap<String, Integer> hm = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        int k = 0;
        for(String p : players){
            hm.put(p, k++);
        }
        for(String s : callings){
            int i = hm.get(s);
            players[i] = players[i - 1];
            players[i - 1] = s;
            hm.put(players[i], i);
            hm.put(players[i-1], i-1);
        }
        answer = players;
        
        return answer;
    }
}