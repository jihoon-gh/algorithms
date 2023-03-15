class Solution {
    
    public int solution(int[] stones, int k) {
        int s = 1;
        while(s < stones.length){
            s *= 2;
        }
        int[] arr = new int[2 * s];
        int t = 0;
     
        for(int i = s; i <= s + stones.length - 1; i++){
            arr[i] = stones[i-s];
        }
       
        for(int i = s; i <= s + stones.length - 1; i++){
            int x = i / 2;
            while(x > 0){
                arr[x] = Math.max(arr[x], arr[i]);
                x /= 2;
            }
        }
        int answer = 2000000001;
        for(int i = s; i <= s + stones.length - k; i++){
            int n = getMax(i, i + k - 1, arr);
            answer = Math.min(answer, n);
        }
        
        return answer;
    }
    public int getMax(int left, int right, int[] arr){
        
        int max = 0;
        while(left <= right){
            if(left % 2 == 1){
                max = Math.max(max, arr[left]);
                left++;
            }
            if(right % 2 == 0){
                max = Math.max(max, arr[right]);
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return max;
    }
}