import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        for(int x : score){
            if(pq.size() < k){
                pq.add(x);
            }
            else{
                int y = pq.peek();
                if(x > y){
                    pq.poll();
                    pq.add(x);
                }
            }
            answer[idx++] = pq.peek();
        }
        return answer;
    }
}