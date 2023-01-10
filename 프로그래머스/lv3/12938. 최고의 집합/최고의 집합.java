import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[n];
        int k = (int)Math.floor(s / n);
        int count = s - k * n;
        for(int i = 0; i < n ; i++){
            answer[i] = k;
            if(count>=n-i){
                answer[i]++;
            }
        }
        return answer;
    }
}