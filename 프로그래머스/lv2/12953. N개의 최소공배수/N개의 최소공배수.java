class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int res = arr[0];
        for(int i = 1; i < arr.length; i++){
            int tmp = gcd(res, arr[i]);
            res = res * arr[i] / tmp;
        }
        answer = res;
        return answer;
    }
    public static int gcd(int a, int b){
        if( b == 0) return a;
        else return gcd(b, a % b);
    }
}