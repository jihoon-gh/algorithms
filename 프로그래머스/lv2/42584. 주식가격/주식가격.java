import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = -1;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            if(st.isEmpty()){
                st.add(i);
            }
            else{
               while(!st.isEmpty() && prices[i] < prices[st.peek()]){
                   int k = st.pop();
                   answer[k] = i - k;
               }
                st.add(i);
            }
        }
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == -1){
                answer[i] = answer.length - i - 1;
            }
        }
        
        return answer;
    }
}