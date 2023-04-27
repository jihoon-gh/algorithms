class Solution {
    public int[] solution(int[] array) {
        int index = 0;
        int value = 0;
        for(int i = 0; i < array.length; i++){
            if(value < array[i]){
                value = array[i];
                index = i;
            }
        }
        int[] answer = {value, index};
        return answer;
    }
}