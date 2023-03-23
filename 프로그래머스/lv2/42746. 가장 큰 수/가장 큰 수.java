import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i : numbers){
            alist.add(i);
        }
        Collections.sort(alist, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                String s1 = Integer.toString(i1);
                String s2 = Integer.toString(i2);
                String res1 = s1 + s2;
                String res2 = s2 + s1;
                int x = Integer.parseInt(res1);
                int y = Integer.parseInt(res2);
                return y - x;
            }
        });
        StringBuilder sb = new StringBuilder();
        int zeroCount = 0;
        for(Integer i : alist){
            if(i == 0) zeroCount++;
            sb.append(Integer.toString(i));
        }
        answer = sb.toString();
        if(answer.length() == zeroCount){
            answer = "0";
        }
        return answer;
    }
}