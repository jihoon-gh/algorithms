import java.util.*;
import java.io.*;

public class Main {


    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

    static int[] searchOrder; // 발견 순서
    static int order = 1; // 발견 순서는 1

    static boolean[] isCut; //단절 노드인지 확인

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            nodes.add(temp);
        }
        searchOrder = new int[n+1];
        isCut = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            if(searchOrder[i] == 0){
                dfs(i, true);
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(isCut[i]){
                ans++;
            }
        }
        System.out.println(ans);
        for(int i = 1; i <= n; i++){
            if(isCut[i]){
                System.out.print(i+" ");
            }
        }
    }
    public static int dfs(int now, boolean isRoot){
        searchOrder[now] = order++;
        int ret = searchOrder[now];
        int child = 0;
        for(int next : nodes.get(now)){

            if(searchOrder[next] != 0) { // 다음 노드가 이미 계산이 되어 있다면
                ret = Math.min(ret, searchOrder[next]); // 그 중에 젤 작은거 ( 젤 빨리 방문한 거)
                continue;
            }
            child++;

            int prev = dfs(next, false); // low 값 찾는거임

            if(!isRoot && prev >= searchOrder[now]){ // 지금꺼 순서보다 더 크다면
                isCut[now] = true; // 단
            }

            ret = Math.min(ret, prev); // 이건
        }

        if(isRoot && child >= 2){
            isCut[now] = true;
        }

        return ret;
    }
}
