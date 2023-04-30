class Solution {
    static int[] arr;
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int s = 1;
        while( s < sequence.length){
            s *= 2;
        }
        arr = new int[2 * s];
        for(int i = s; i < s + sequence.length; i++){
            arr[i] = sequence[i - s];
            int x = i/2;
            while(x > 0){
                arr[x] += arr[i];
                x /= 2;
            }
        }
        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int ansRight = 1000000;
        while(right < sequence.length){
            int sum = getSum(left, right, s);
            if(sum == k){
                if(ansRight - ansLeft > right - left){
                    ansRight = right;
                    ansLeft = left;
                }
                right++;
                left++;
                continue;
            }
            if(sum < k){
                right++;
                continue;
            }
            if(sum > k){
                if(left == right){
                    left++;
                    right++;
                }
                else{
                    left++;
                }
                continue;
            }
        }
        answer[0] = ansLeft;
        answer[1] = ansRight;
        return answer;
    }
    public static int getSum(int left, int right, int s){
        left = left + s;
        right = right + s;
        int sum = 0;
        while(left <= right){
            if(left % 2 == 1){
                sum += arr[left];
                left++;
            }
            if( right % 2 == 0){
                sum += arr[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}