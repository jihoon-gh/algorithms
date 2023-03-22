import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

       Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.add(s.charAt(i));
                continue;
            }
            else{
                char c = st.pop();
                if( c == s.charAt(i)){
                    continue;
                }else{
                    st.add(c);
                    st.add(s.charAt(i));
                }
            }
        }

        if(st.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}