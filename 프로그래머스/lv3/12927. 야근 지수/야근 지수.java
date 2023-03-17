import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        
        for(int i : works){
            pq.add(i);
        }
        
        long answer = 0;
        for(int i = n; i > 0; i--){
            int k = pq.poll();
            k--;
            if(k < 0){
                answer = 0;
                return answer;
            }
            pq.add(k);
        }
        while(!pq.isEmpty()){
            int k = pq.poll();
            answer += Math.pow(k, 2);
        }
        return answer;
    }
}