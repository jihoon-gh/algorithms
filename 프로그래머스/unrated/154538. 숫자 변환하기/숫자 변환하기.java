class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];
        for(int i = 0; i <= y; i++){
            dp[i] = 1000001;
        }
        dp[x] = 0;
        for(int i = x + 1; i <= y; i++){
            if(i - x >= n){
                dp[i] = Math.min(dp[i-n] + 1, dp[i]);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        if(dp[y] == 1000001){
            answer = -1;
            return answer;
        }
        answer = dp[y];
        return answer;
    }
}