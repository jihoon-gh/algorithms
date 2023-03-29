import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            s = s.substring(1) + s.substring(0, 1);
            char[] splits = s.toCharArray();
            Stack<Character> st1 = new Stack<>();
            Stack<Character> st2 = new Stack<>();
            Stack<Character> st3 = new Stack<>();
            Stack<Character> st = new Stack<>();
            boolean res = true;
            int last = 0;
            for(int j = 0; j < splits.length; j++){
                char c = splits[j];
                if(c =='('){
                    st1.add(c);
                    st.add(c);
                    last = 1;
                }
                if(c == ')'){
                    if(st1.isEmpty()){
                        res = false;
                        break;
                    }
                    else{
                        if(st.peek() !='('){
                            res = false;
                            break;
                        }
                        st1.pop();
                        st.pop();
                    }
                }
                if(c == '['){
                    st2.add(c);
                    st.add(c);
                    last = 2;
                }
                if(c == ']'){
                    if(st2.isEmpty()){
                        res = false;
                        break;
                    }
                    else{
                        if(st.peek() !='['){
                            res = false;
                            break;
                        }
                        st2.pop();
                        st.pop();
                    }
                }
                if(c == '{'){
                    st3.add(c);
                    st.add(c);
                    last = 3;
                }
                if(c =='}'){
                    if(st3.isEmpty()){
                        res = false;
                        break;
                    }
                    else{
                        if(st.peek() !='{'){
                            res = false;
                            break;
                        }
                        st3.pop();
                        st.pop();
                    }
                }
            }
            if(!st1.isEmpty() || !st2.isEmpty() || !st3.isEmpty()){
                res = false;
            }
            if(res){
                answer++;
            }
        }
        return answer;
    }
}