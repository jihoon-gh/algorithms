import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<String> alist = new ArrayList<>();
        String answer = "";
        boolean isBlank = false;
        int start = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                if(!isBlank){
                    String temp = s.substring(start, i);
                    alist.add(temp);
                    isBlank = true;
                    start = i;
                }else{
                    continue;
                }
            }
            if(c != ' '){
                if(isBlank){
                    String temp = s.substring(start, i);
                    alist.add(temp);
                    isBlank = false;
                    start = i;
                }else{
                    continue;
                }
            }
        }
        alist.add(s.substring(start));
        for(String temp : alist){
            if(temp.isEmpty()){
                answer += temp;
                continue;
            }
            else{
                char c = temp.charAt(0);
                if(c >= 'a' && c <= 'z'){
                    c = (char)((int)c - 32);
                }
                String k = c + temp.substring(1).toLowerCase();
                answer += k;
                continue;
            }
        }
        return answer;
    }
}