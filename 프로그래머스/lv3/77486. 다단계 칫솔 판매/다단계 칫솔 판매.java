import java.util.*;

class Solution {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> money = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            if(referral[i].equals("-")){
                parent.put(enroll[i], "center");
            }
            else{
                parent.put(enroll[i], referral[i]);
            }
            money.put(enroll[i], 0);
        }
        money.put("center", 0);
        for(int i = 0; i < seller.length; i++){
            String s = seller[i];
            int m = amount[i] * 100;
            
            while(m > 0){
                //System.out.println("1 "+s+" "+m);
                int temp = money.get(s);
                if((int)(m * 0.1) < 1){
                    temp += m;
                }
                else temp += m - (int)(m * 0.1);
                money.put(s, temp);
               //System.out.println("2 "+s+" "+temp);
                m = (int)(m * 0.1);
                s = parent.get(s);
                if(s.equals("center")) break;
            }
        }
        int idx = 0;
        for(String e : enroll){
            answer[idx++] = money.get(e);
        }
        return answer;
    }
}