import java.util.*;

class Solution {
    static int[] arr = new int[26];
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        for(int i = 0; i < 26; i++){
            arr[i] = 100000;
        }
        for(String s : keymap){
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int k = (int)(c - 'A');
                arr[k] = Math.min(arr[k], i+1);
            }
        }
        ArrayList<Integer> alist = new ArrayList<>();
        for(String s : targets){
            int res = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                int k = (int)(c - 'A');
                res += arr[k];
            }
            if(res >= 100000){
                alist.add(-1);
            }else{
                alist.add(res);
            }
        }
        answer = alist.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}