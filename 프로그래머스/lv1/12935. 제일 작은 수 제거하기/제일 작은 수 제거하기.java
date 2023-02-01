import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int x = 987654321;
        for(int i = 0; i < arr.length; i++){
            x = Math.min(x, arr[i]);
        }
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) continue;
            answer[idx++] = arr[i];
        }
        if(answer.length==0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        return answer;
    }
}