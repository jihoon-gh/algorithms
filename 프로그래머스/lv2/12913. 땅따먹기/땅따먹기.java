class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i-1][k], dp[i][j]);
                }
                dp[i][j] += land[i][j];
            }    
        }
        int n = land.length - 1;
        answer= Math.max(Math.max(dp[n][0], dp[n][1]), Math.max(dp[n][2], dp[n][3]));

        return answer;
    }
}