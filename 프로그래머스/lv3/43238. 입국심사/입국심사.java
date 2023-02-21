import java.util.*;

class Solution {
    public long solution(long n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        answer = binarySearch(n, times);
        return answer;
    }
    
    public long binarySearch(long n, int[] times){
        long temp = 0;
        for(int i = 0; i < times.length; i++){
            temp = Math.max(times[i], temp);
        }
        
        
        long x = -1;
        for(long b = temp * n; b >= 1; b /=2){
            while(!isValid(n, x+b, times)) x += b;
        }
        return x+1;
    }
    
    public boolean isValid(long n, long x ,int[] times){
        long res = 0;
        for(int t : times){
           res = res + (x / t);
        }
        if( res >= n) return true;
        else return false;
    }
}