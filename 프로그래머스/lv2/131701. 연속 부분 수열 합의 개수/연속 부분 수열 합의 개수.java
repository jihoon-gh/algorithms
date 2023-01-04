class Solution {
    
    public static int[][] arr = new int[1000][1001]; //시작점, 갯수
    public static int[] count = new int[1000001];
    public int solution(int[] elements) {
        int answer=0;
        int n = elements.length;
        for(int i = 0 ; i < n; i++){
            for(int j = 1; j <=n; j++){
                if(i+j>=n){
                    arr[i][j]=arr[i][j-1]+elements[i+j-n];
                }
                else arr[i][j] = arr[i][j-1]+elements[i+j];
                count[arr[i][j]]++;
            }
        }
        
        for(int i = 0; i < 1000001; i++){
            if(count[i]!=0){
                answer++;
            }
        }
        return answer;
    }
}