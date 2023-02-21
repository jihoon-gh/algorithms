import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] count;
    static int[] visited;

    static PriorityQueue<Integer> availableNodes = new PriorityQueue<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        count = new int[n+1];
        visited = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            count[b]++;
        }

        for(int i = 1; i<= n; i++){
            if(count[i] == 0) {
                availableNodes.add(i);
            }
        }
        while(!availableNodes.isEmpty()){
            int k = availableNodes.poll();
            dfs(k);
        }
        for(int x : ans){
            System.out.print(x+" ");
        }
    }
    public static void dfs(int now){
        if(visited[now]!=0) return ;
        visited[now] = 1;
        ans.add(now);
        for(int x : adj.get(now)){
            count[x]--;
            if(count[x]==0){
                availableNodes.add(x);
            }
        }
        while(!availableNodes.isEmpty()){
            dfs(availableNodes.poll());
        }
        visited[now] = 2;
        return ;
    }

}
