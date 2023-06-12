class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n, 3);
        String res = new StringBuilder(s).reverse().toString();
        answer = Integer.parseInt(res, 3);
        return answer;
    }
}