import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] splits = Integer.toString(n).split("");
        for(String s : splits){
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}