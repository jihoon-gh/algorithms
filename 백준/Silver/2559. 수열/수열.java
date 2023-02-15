import java.util.*;
import java.io.*;

public class Main {


    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = 1;
        while(s < n){
            s *= 2;
        }

        arr = new int[2 * s];
        st = new StringTokenizer(br.readLine());
        for(int i = s; i <= s + n - 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int k = i / 2;
            while(k > 0){
                arr[k] += arr[i];
                k /= 2;
            }
        }
        int res = -2000000000;
        for(int i = 1; i <= n- m +1; i++) {
            res = Math.max(res, getMax(i, i + m - 1, s));
        }
        System.out.println(res);
    }
    public static int getMax(int left, int right, int s){
        left = left + s -1;
        right = right + s -1;
        int res = 0;
        while(left <= right){
            if(left % 2 == 1){
                res += arr[left];
                left++;
            }
            if(right % 2 == 0){
                res += arr[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return res;
    }
}
