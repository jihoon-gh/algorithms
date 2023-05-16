import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        for(String s : cards1){
            s1.add(s);
        }
        for(String s : cards2){
            s2.add(s);
        }
        List<String> slist1 = new ArrayList<>();
        List<String> slist2 = new ArrayList<>();
        for(String s : goal){
            if(s1.contains(s)){
                slist1.add(s);
            }else{
                slist2.add(s);
            }
        }
        boolean k = true;
        for(int i = 0; i < slist1.size(); i++){
            if(!slist1.get(i).equals(cards1[i])){
                k = false;
            }
        }
         for(int i = 0; i < slist2.size(); i++){
            if(!slist2.get(i).equals(cards2[i])){
                k = false;
            }
        }
        if(k){
            answer = "Yes";
        }
        else{
            answer = "No";
        }
        
        return answer;
    }
}