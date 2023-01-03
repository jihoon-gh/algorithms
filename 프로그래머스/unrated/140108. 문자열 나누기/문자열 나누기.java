class Solution {
    public int solution(String s) {
        int answer = 0;
        answer = getRes(s);
        return answer;
    }
    
    public static int getRes(String s){
        if(s=="") return 0;
        if(s.length()==1) return 1;
        int same = 1;
        int diff = 0;
        char c = s.charAt(0);
        for(int i = 1; i < s.length()-1; i++){
            if(s.charAt(i)==c) same++;
            if(s.charAt(i)!=c) diff++;
            if(same==diff){
                return 1 + getRes(s.substring(i+1));
            }
        }
        return 1;
    }
}