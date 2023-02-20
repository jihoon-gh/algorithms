import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    static boolean[] visited;
    static ArrayDeque<String> nums = new ArrayDeque<>();

    static boolean[] arr = new boolean[10000001];
    static String[] splits;

    static List<Integer> ans = new ArrayList<>();
    static int answer = 0;
    
    public int solution(String numbers) {
        
        arr[0] = true;
        arr[1] = true;
        for(int i = 2; i <= 10000000; i++){
            if(arr[i]) continue;
            int j = 2;
            while(i * j <= 10000000){
                arr[i*j] = true;
                j++;
            }
        }
        splits = numbers.split("");
         visited = new boolean[splits.length];
        for(int i = 1; i <= splits.length; i++){
            dfs(i);
        }

        ans = ans.stream().distinct().collect(Collectors.toList());
        for(int x  :ans){
            if(!arr[x]){
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int len){
        if(nums.size() == len){
            String s = "";
            for(String temp : nums){
                s+=temp;
            }
            int k = Integer.parseInt(s);
            ans.add(k);
            return ;
        }
        for(int i = 0; i < splits.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums.addLast(splits[i]);
            dfs(len);
            nums.removeLast();
            visited[i] = false;
        }
    }
}