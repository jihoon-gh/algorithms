import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int max_nodes = 100001;
    static int[][] ac = new int[max_nodes][21];
    static int max_level = (int)Math.floor(Math.log(max_nodes)/Math.log(2));
    static int[] depth = new int[max_nodes];

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<= n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i = 0 ; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        depth[0] = -1;
        makeTree(1, 0);


        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(depth[a] != depth[b]){
                if(depth[a] > depth[b]){
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
            }
            for(int  j = max_level; j >= 0; j--){
                if(depth[a] <= depth[ac[b][j]]){
                    b = ac[b][j];
                }
            }
            int lca  = a;
            if(a == b){
                System.out.println(lca);
                continue;
            }
            for(int j = max_level; j >= 0; j--){
                if(ac[a][j] != ac[b][j]){
                    a = ac[a][j];
                    b = ac[b][j];
                }
                lca = ac[a][j];
            }
            System.out.println(lca);
        }
    }
    public static void makeTree(int now, int parent){
        depth[now] = depth[parent]+1;
        ac[now][0] = parent;

        for(int i = 1 ; i <= max_level; i++){
            int tmp = ac[now][i-1];
            ac[now][i] = ac[tmp][i-1];
        }

        for(int a : adj.get(now)){
            if(a == parent) continue;
            makeTree(a, now);
        }
    }
}
