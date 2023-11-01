import java.util.*;

class Solution {
    static class Pair{
        int x;
        int y;
        public Pair(int a, int b){
            x = a;
            y = b;
        }
    }
    public int[] solution(String[] wallpaper) {
        List<Pair> plist = new ArrayList<>();
        for(int i = 0; i < wallpaper.length; i++){
            char[] carr = wallpaper[i].toCharArray();
            for(int j = 0; j < carr.length; j++){
                if(carr[j] == '#'){
                    plist.add(new Pair(i, j));
                }
            }
        }
        int minX = 1000000000;
        int maxX = 0;
        int minY = 1000000000;
        int maxY = 0;
        for(Pair p : plist){
            int x = p.x;
            int y = p.y;
            maxX = Math.max(x, maxX);
            minX = Math.min(x, minX);
            maxY = Math.max(y, maxY);
            minY = Math.min(y, minY);
        }
        int[] answer = {minX, minY, maxX + 1, maxY + 1};
        return answer;
    }
}