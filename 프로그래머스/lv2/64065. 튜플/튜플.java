import java.util.*;

class Solution {
    public int[] solution(String s) {
		String[] splits = s.split("}");
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(String tmp : splits){
            String k = tmp.substring(2);
            String[] splits2 = k.split(",");
            ArrayList<Integer> tempList = new ArrayList<>();
            for(String temp : splits2){
                tempList.add(Integer.parseInt(temp));
            }
            alist.add(tempList);
        }
        Collections.sort(alist, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2){
                return l1.size() - l2.size();
            }
        });
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(alist.get(0).get(0));
        
        
        for(int i = 1; i < alist.size(); i++){
            HashSet<Integer> now  = new HashSet<>(alist.get(i-1));
            ArrayList<Integer> target = alist.get(i);
            for(Integer x : target){
                if(!now.contains(x)) {
                	answerList.add(x);
                }
            }
        }
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}