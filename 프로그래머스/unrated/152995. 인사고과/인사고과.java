import java.util.*;

class Solution {
    static class Pair{
        public int x;
        public int y;
        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
    
    public int solution(int[][] scores) {
        int answer = 0;
        int wanho = scores[0][0] + scores[0][1];
        boolean isNoIncen = false;
        for(int i = 1; i < scores.length; i++){
            if(scores[i][0] > scores[0][0] && scores[i][1] > scores[0][1]){
                isNoIncen = true;
                break;
            }
        }
        
        if(isNoIncen){
            answer = -1;
            return answer;
        }
        Arrays.sort(scores, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr2[1] == arr1[1]){
                    return arr1[0] - arr2[0];
                }
                return arr2[1] - arr1[1];
            }
        });
        ArrayList<Pair> pList = new ArrayList<>();
        int maxX = 0;
        for(int i = 0; i < scores.length; i++){
            if(maxX > scores[i][0]){
                continue;
            }
            else{
                maxX = Math.max(maxX, scores[i][0]);
                pList.add(new Pair(scores[i][0], scores[i][1]));
            }
        }
        Collections.sort(pList, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return (p2.x + p2.y) - (p1.x + p1.y);
            }
        });
        
        int same = 0;
        int before = -1;
        for(Pair p : pList){
            if(p.x + p.y == before){
                same++;
            }
            else{
                answer = answer + same + 1;
                same = 0;
            }
            before = p.x + p.y;
            if(before == wanho){
                break;
            }
        }
        
        return answer;
        
    }
}