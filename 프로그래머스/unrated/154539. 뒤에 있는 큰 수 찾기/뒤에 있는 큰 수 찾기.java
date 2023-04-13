import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= numbers[i]){
                st.pop();
            }
            int k = st.isEmpty() ? -1 : st.peek();
            answer[i] = k;
            st.add(numbers[i]);
        }
        return answer;
    }
}