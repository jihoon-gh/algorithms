
import java.io.*;

public class Main {

    static char[][] arr = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int r = Integer.parseInt(splits[0]);
        int c = Integer.parseInt(splits[1]);
        int k = Integer.parseInt(splits[2]);
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        Point p = new Point(r-1, 0);
        Point fin = new Point(r, c);
        dfs(p, fin, 0, k);
        System.out.println(answer);
        return ;
    }
    static class Point{
        private int x;
        private int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }


    public static void dfs(Point p, Point fin, int distance, int k){
        int x = p.getX();
        int y = p.getY();
        int r = fin.getX();
        int c = fin.getY();

        if(x >= r || x < 0 || y >= c || y < 0) {
            return ;
        }

        if(visited[x][y]){
            return ;
        }

        if(arr[x][y] == 'T'){
            return;
        }

        if( x == 0 && y == c-1 && distance == k-1){
            answer++;
            return;
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i = 0; i < 4; i++){
            visited[x][y] = true;
            Point p1 = new Point(x+dx[i], y+dy[i]);
            dfs(p1, fin, distance+1, k);
            visited[x][y] = false;
        }
        return ;
    }
}