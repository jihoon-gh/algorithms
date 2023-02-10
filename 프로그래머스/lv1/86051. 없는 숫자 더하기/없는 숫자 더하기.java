class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] checker = new boolean[10];
        for(int i : numbers){
            checker[i]=true;
        }
        for(int i = 0; i < checker.length; i++){
            if(!checker[i]) answer += i;
        }
        return answer;
    }
}