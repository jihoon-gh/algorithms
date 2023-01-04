/**
1부터 count 까지 더한 값에 price를 곱함
시그마 계산식에 따라 1-n까지의 계산값은 n(n+1)/2
*/

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long totalPrice = count * (count + 1) / 2;
        totalPrice = totalPrice * price;
        answer = totalPrice - money;
        if(answer<=0) return 0;
        return answer;
    }
}