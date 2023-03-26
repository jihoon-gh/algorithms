import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<String>> hm = new HashMap<>();
    static ArrayDeque<String> ad = new ArrayDeque<>();
    static HashSet<HashSet<String>> hs = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        int answer = 0;
        for(String b : banned_id){
            hm.put(b, new ArrayList<String>());
            for(String id : user_id){
                if(isBanned(b, id)){
                    hm.get(b).add(id);
                }
            }
        }
        
        dfs(0, banned_id);
        answer = hs.size();
        return answer;
    
    }
    public static void dfs(int now, String[] banned_id){
        if(ad.size() == banned_id.length){
            HashSet<String> temp = new HashSet<>();
            for(String s : ad){
                temp.add(s);
            }
            if(banned_id.length == temp.size()){
                hs.add(temp);
            }
            return;
        }
        String curr = banned_id[now];
        for(String s : hm.get(curr)){
            ad.addLast(s);
            dfs(now+1, banned_id);
            ad.pollLast();
        }
        
    }
    public static boolean isBanned(String b, String id){
        if(b.length() == id.length()){
            for(int i = 0; i < b.length(); i++){
                if(b.charAt(i) == '*'){
                    continue;
                }
                if(b.charAt(i) != id.charAt(i)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}