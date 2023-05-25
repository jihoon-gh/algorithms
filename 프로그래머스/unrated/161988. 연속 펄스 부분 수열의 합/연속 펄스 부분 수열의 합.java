class Solution {
    static long[] sequence1;
    static long[] sequence2;
    static long[] dp1;
    static long[] dp2;
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        sequence1 = new long[n];
        sequence2 = new long[n];
        dp1 = new long[n];
        dp2 = new long[n];
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                sequence1[i] = sequence[i];
                sequence2[i] = (-1) * sequence[i];
            }
            else{
                sequence1[i] = (-1) * sequence[i];
                sequence2[i] = sequence[i];
            }
        }
        
        long ans1 = 0;
        long ans2 = 0;
        
        dp1[0] = sequence1[0];
        ans1 = dp1[0];
        for(int i = 1; i < n; i++){
            dp1[i] = Long.max(dp1[i-1] + sequence1[i], sequence1[i]);
            ans1 = Long.max(dp1[i], ans1);
        }
        
        dp2[0] = sequence2[0];
        ans2 = dp2[0];
        for(int i = 1; i < n; i++){
            dp2[i] = Long.max(dp2[i-1] + sequence2[i], sequence2[i]);
            ans2 = Long.max(dp2[i], ans2);
        }
        
        answer = Long.max(ans1, ans2);
        return answer;
    }
}