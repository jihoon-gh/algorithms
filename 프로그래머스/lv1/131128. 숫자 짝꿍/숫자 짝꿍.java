import java.math.*;
import java.io.*;
class Solution {
    
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] nums = new int[10];
        String answer = "";
        String[] splits1 = X.split("");
        String[] splits2 = Y.split("");
        for(int i = 0; i < splits1.length; i++){
            int k = Integer.parseInt(splits1[i]);
            arr1[k]++;
        }
        for(int i = 0; i < splits2.length; i++){
            int k = Integer.parseInt(splits2[i]);
            arr2[k]++;
        }
        for(int i = 0 ; i < 10; i++){
            nums[i] = Math.min(arr1[i], arr2[i]);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i>=0; i--){
            if(i == 0 && count == 9 && nums[i] != 0){
                sb.append(0);
                break;
            }
            if(nums[i]==0) {
                count++;
                continue;
            }
            while(nums[i] > 0){
                sb.append(i);
                nums[i]--;
            }
        }
        answer = sb.toString();
        if(answer.isBlank()){
            answer= "-1";
            return answer;
        }
        return answer;
    }
}