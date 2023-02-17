import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        public int next;
        public int weight;
        public Pair(int a, int b){
            next = a;
            weight = b;
        }
    }
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    static int max_nodes = 100001;
    static int[][] ac = new int[max_nodes][21];
    static int max_level = (int)Math.floor(Math.log(max_nodes)/Math.log(2));
    static int[] depth = new int[max_nodes];

    static int[][] minDist = new int[max_nodes][21];
    static int[][] maxDist = new int[max_nodes][21];

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<= n; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i = 0 ; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(b, w));
            adj.get(b).add(new Pair(a, w));
        }
        depth[0] = -1;
        doBfs(1);
        makeTree();

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans_min = 1000000000;
            int ans_max = 0;

            if(depth[a] != depth[b]){
                if(depth[a] > depth[b]){
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
            }
            for(int  j = max_level; j >= 0; j--){
                if(depth[a] <= depth[ac[b][j]]){
                    ans_min = Math.min(ans_min, minDist[b][j]);
                    ans_max = Math.max(ans_max, maxDist[b][j]);
                    b = ac[b][j];
                }
            }
            int lca  = a;
            if( a == b){
                System.out.println(ans_min + " " + ans_max);
                continue;
            }
            if(a != b) {
                for (int j = max_level; j >= 0; j--) {
                    if (ac[a][j] != ac[b][j]) {
                        ans_min = Math.min(ans_min, Math.min(minDist[a][j], minDist[b][j]));
                        ans_max = Math.max(ans_max, Math.max(maxDist[a][j], maxDist[b][j]));
                        a = ac[a][j];
                        b = ac[b][j];
                    }
                }
            }
            ans_min = Math.min(ans_min, Math.min(minDist[a][0], minDist[b][0]));
            ans_max = Math.max(ans_max, Math.max(maxDist[a][0], maxDist[b][0]));
            System.out.println(ans_min+" "+ans_max);
        }
    }
    public static void doBfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        depth[start] = 1;
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Pair p : adj.get(now)){
                if(depth[p.next] == 0){
                    depth[p.next] = depth[now] + 1;
                    ac[p.next][0] = now;
                    minDist[p.next][0] = p.weight;
                    maxDist[p.next][0] = p.weight;
                    queue.add(p.next);
                }
            }
        }
    }
    public static void makeTree(){
        for(int i = 1; i<=max_level; i++){
            for(int j = 1; j<max_nodes; j++){
                int tmp = ac[j][i-1];
                ac[j][i] = ac[tmp][i-1];
                minDist[j][i] = Math.min(minDist[j][i-1], minDist[tmp][i-1]);
                maxDist[j][i] = Math.max(maxDist[j][i-1], maxDist[tmp][i-1]);
            }
        }
    }
}
