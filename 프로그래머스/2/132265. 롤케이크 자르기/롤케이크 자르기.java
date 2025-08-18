import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for(int i = 0 ; i < n; i++) {
            int x = topping[i];
            rightSet.add(x);
            rightMap.put(x, rightMap.getOrDefault(x, 0) + 1);
        }
        
        for(int i = 0; i < n; i++) {
            int k = topping[i];
            leftSet.add(k);
            leftMap.put(k, leftMap.getOrDefault(k, 0) + 1);
            int x = rightMap.get(k) - 1;
            rightMap.put(k, x);
            if(x == 0) {
                rightSet.remove(k);
            }
            if(leftSet.size() == rightSet.size()) {
                answer++;
            }
        }
        return answer;
    }
}