class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int numP = 0;
        int numY= 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='p' || c == 'P') numP++;
            if(c=='y'|| c=='Y') numY++;
        }
        if(numP!=numY) {
            answer = false;
        }

        return answer;
    }
}