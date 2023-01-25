class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n ;i++){
            dp[i] = (dp[i-1] % 1234567 + dp[i - 2] % 1234567) % 1234567;
        }
        return answer = dp[n];
    }
}