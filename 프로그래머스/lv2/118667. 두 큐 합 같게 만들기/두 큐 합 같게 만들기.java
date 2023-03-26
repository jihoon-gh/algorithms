import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        long total = 0;
        for(int i : queue1){
            sum1 += i;
        }
        for(int i : queue2){
            sum2 += i;
        }
        total = sum1 + sum2;
        if(!isOk(queue1, total/2) || !isOk(queue2, total/2) || total % 2 == 1){
            answer = -1;
            return answer;
        }
        Queue<Integer> q1 = new LinkedList<>();
        for(int i : queue1){
            q1.add(i);
        }
        Queue<Integer> q2 = new LinkedList<>();
        for(int i : queue2){
            q2.add(i);
        }
        while(sum1 != sum2 && answer <= 1200000){
            while(sum1 > total/2){
                int k = q1.poll();
                sum1 -= k;
                q2.add(k);
                sum2 += k;
                answer++;
            }
            while(sum2 > total/2){
                int k = q2.poll();
                sum2 -= k;
                q1.add(k);
                sum1 += k;
                answer++;
            }
        }
        if(answer > 1200000){
            answer = -1;
        }
        return answer;
    }
    public static boolean isOk(int[] arr, long max){
        for(int i : arr){
            if(i > max){
                return false;
            }
        }
        return true;
    }
}