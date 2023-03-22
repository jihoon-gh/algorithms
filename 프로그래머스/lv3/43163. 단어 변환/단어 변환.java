import java.util.*;

class Solution {
    static HashMap<String, Integer> dist = new HashMap<>();
    static HashSet<String> hs = new HashSet<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        for(String w : words){
            hs.add(w);
        }
        bfs(begin);
        answer = dist.getOrDefault(target, 0);
        return answer;
    }
    public static void bfs(String start){
        dist.put(start, 0);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            String now = q.poll();
            for(int i = 0; i < now.length(); i++){
                char c = now.charAt(i);
                for(int j = 97; j <= 122; j++){
                    char t = (char)j;
                    if(t == c) continue;
                    String s = now.substring(0,i) + t + now.substring(i+1);
                    if(!hs.contains(s)) continue;
                    int k = dist.getOrDefault(s, -1);
                    if(k != -1) continue;
                    int nowDist = dist.get(now);
                    dist.put(s, nowDist+1);
                    q.add(s);
                }
            }
        }
    }
}