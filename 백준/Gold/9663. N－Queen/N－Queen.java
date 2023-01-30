import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    static boolean[] col = new boolean[16];
    static boolean[] leftCross = new boolean[33];
    static boolean[] rightCross = new boolean[33];
    static int n ;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());

       back(1);

       System.out.println(ans);
    }
    public static void back(int x){
        if(x == n+1){
            ans++;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(col[i]==false && leftCross[x+i]==false && rightCross[x-i+n]==false){
                col[i]=true;
                leftCross[x+i]=true;
                rightCross[x-i+n]=true;
                back(x+1);
                col[i]=false;
                leftCross[x+i]=false;
                rightCross[x-i+n]=false;
            }
        }
    }
}