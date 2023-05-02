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
    static List<Pair> plist = new ArrayList<>();
    static List<Integer> alist = new ArrayList<>();
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1 ,0, 0};
    public int[] solution(String[] maps) {
        int[] answer;
        n = maps.length;
        m = maps[0].length();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) =='X') arr[i][j] = 0;
                else {
                    arr[i][j] = (int)(maps[i].charAt(j) - '0');
                    plist.add(new Pair(i, j));
                }
            }
        }
        if(plist.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        for(Pair p : plist){
            int x = p.x;
            int y = p.y;
            if(visited[x][y]) continue;
            else{
                int k = bfs(x, y);
                alist.add(k);
            }
        }
        Collections.sort(alist);
        answer = alist.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    public static int bfs(int x, int y){
        int res = 0;
        res += arr[x][y];
        visited[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int rx = p.x + dx[i];
                int ry = p.y + dy[i];
                if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;
                if(visited[rx][ry]) continue;
                visited[rx][ry] = true;
                if(arr[rx][ry] == 0) continue;
                res += arr[rx][ry];
                q.add(new Pair(rx, ry));
            }
        }
        return res;
    }
}