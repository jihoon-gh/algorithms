class Solution {
    
    static int ansZero = 0;
    static int ans = 0;
    public int[] solution(String s) {
        while(true){
           if(s.equals("1")){
               break;
           }
            int len = func(s);
            ansZero += s.length() - len;
            s = Integer.toBinaryString(len);
            ans++;
        }
        int[] answer = {ans, ansZero};
        return answer;
    }
    public static int func(String s){
        String tmp ="";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1')
                tmp += "1";
        }
        return tmp.length();
    }
    public static boolean hasZero(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='0'){
                return true;
            }
        }
        return false;
    }
}