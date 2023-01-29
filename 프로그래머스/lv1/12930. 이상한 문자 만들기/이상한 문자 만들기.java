import java.util.*;
import java.io.*;

class Solution {
    public String solution(String k) {
        String answer = "";
        int count = 0;
        for(int i = 0; i < k.length(); i++){
            char c = k.charAt(i);
            if(c == ' '){
                count = 0;
                answer+= ' ';
                continue;
            }
            if(count % 2 == 0){
                answer += Character.toUpperCase(c);
            }else{
                answer += Character.toLowerCase(c);
            }
            count++;
        }
        return answer;
    }
}