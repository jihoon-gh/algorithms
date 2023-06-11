class Solution {
    static int[][] arr;
    public int solution(int[][] board) {
        arr = board;
        int answer = 0;
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j]==1){
                    changeSafety(i,j,n);
                }
            }
        }
          for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j]==0){
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void changeSafety(int a, int b, int n){
        int[] dx = {1,1,1,-1,-1,-1,0,0};
        int[] dy = {1,0,-1,1,0,-1,1,-1};
        for(int i = 0; i < 8; i++){
            int rx = a + dx[i];
            int ry = b + dy[i];
            if(rx < 0 || rx >=n || ry < 0 || ry >=n){
                continue;
            }
            if(arr[rx][ry]==1) continue;
            arr[a+dx[i]][b+dy[i]] = 2;
        }
    } 
}