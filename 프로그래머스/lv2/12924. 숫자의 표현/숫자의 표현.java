class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        int sum = 0;
        while(left <= right && right <= n+1){
            if(sum == n){
                answer++;
                left++;
                right++;
                sum -= left;
                sum += right;
                continue;
            }
            if(sum < n){
                sum+=right;
                right++;
                continue;
            }
            if(sum > n){
                sum -= left;
                left++;
                continue;
            }
        }
        return answer;
    }
}