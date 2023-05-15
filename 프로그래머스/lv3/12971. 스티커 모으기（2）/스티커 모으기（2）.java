import java.util.*;
/*
** 1. 1 ~ n-1 
** 2. 2 ~ n
*/

class Solution {
    
    static int[] dp1;
    static int[] dp2;
    
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1){
            answer = sticker[0];
            return answer;
        }
        if(sticker.length == 2){
            answer = Integer.max(sticker[0], sticker[1]);
            return answer;
        }
         if(sticker.length == 3){
            answer = Integer.max(sticker[0] + sticker[2], sticker[1]);
            return answer;
        }
        dp1 = new int[sticker.length];
        dp2 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        int res1 = 0;
        for(int i = 2; i < dp1.length - 1; i++){
            dp1[i] = Integer.max(dp1[i-1], dp1[i-2] + sticker[i]);
            res1 = Integer.max(res1, dp1[i]);
        }
        dp2[1] = sticker[1];
        int res2 = 0;
        for(int i = 2; i < dp2.length; i++){
            dp2[i] = Integer.max(dp2[i-1], dp2[i-2] + sticker[i]);
            res2 = Integer.max(res2, dp2[i]);
        }
        answer = Integer.max(res1, res2);
        return answer;
    }
}