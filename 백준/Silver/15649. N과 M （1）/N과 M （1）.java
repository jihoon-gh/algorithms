import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited = new boolean[9];
    static ArrayList<Integer> nums = new ArrayList<>();
    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs();
    }
    public static void dfs(){
        if(nums.size() == m){
            for(int n : nums){
                System.out.print(n+" ");
            }
            System.out.println();
            return ;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums.add(i);
            dfs();
            nums.remove(nums.size() - 1);
            visited[i] = false;
        }
    }
}
