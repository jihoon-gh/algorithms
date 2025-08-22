import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<>(){
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[1] == arr2[1]) {
                    return arr1[0] - arr2[0];
                }
                return arr1[1] - arr2[1];
            }
        });
        int lastPoint = -987654321;
        int n = routes.length;
        for(int i = 0; i < n; i++){
            if(lastPoint < routes[i][0]) {
                answer++;
                lastPoint = routes[i][1];
            }
        }
        return answer;
    }
}