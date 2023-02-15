class Solution {
    static int answer = 0;
    static int count = 0;
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        for(int i = 1;;i++){
            if(isNextBigNum(n+i)){
                answer=n+i;
                break;
            }
            continue;
        }
        return answer;
    }
    public static boolean isNextBigNum(int n){
        int res = 0;
        String s = Integer.toBinaryString(n);
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i)=='1') res++;
        }
        if(count == res){
            return true;
        }
        return false;
    }
}