import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    static int order = 1;
    static int[] searchOrder;

    static boolean[] isCut;
    static List<List<Integer>> nodes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        searchOrder = new int[n+1];
        isCut = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            List<Integer> temp = new ArrayList<>();
            nodes.add(temp);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            if(searchOrder[i] == 0){
                dfs(i,true);
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(isCut[i]) ans++;
        }
        System.out.println(ans);
        for(int i = 0; i <= n; i++){
            if(isCut[i]){
                System.out.print(i+" ");
            }
        }
    }
    public static int dfs(int start, boolean isRoot){
        searchOrder[start] = order++;
        int ret = searchOrder[start];
        int child = 0 ;
        for(int next : nodes.get(start)){

            if(searchOrder[next] != 0){
                ret = Math.min(ret, searchOrder[next]);
                continue;
            }

            child++;
            int prev = dfs(next, false);

            if(!isRoot && prev >= searchOrder[start]){
                isCut[start] = true;
            }

            ret = Math.min(ret, prev);
        }

        if(isRoot && child >= 2){
            isCut[start] = true;
        }

        return ret;
    }
}