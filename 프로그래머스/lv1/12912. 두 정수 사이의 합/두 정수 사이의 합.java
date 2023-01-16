//sum(1, b) - sum(1, a-1)
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        answer = (long)x*(x+1)/2 - (long)y*(y-1)/2;
        return answer;
    }
}