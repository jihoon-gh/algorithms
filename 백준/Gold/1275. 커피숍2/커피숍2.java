import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = 1;
        while(s < n){
            s *= 2;
        }
        arr = new long[2 * s];
        st = new StringTokenizer(br.readLine());
        for(int i = s; i <= s + n - 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = s; i < 2 * s; i++){
            int k = i / 2;
            while( k > 0){
                arr[k] += arr[i];
                k = k / 2;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            long val = Integer.parseInt(st.nextToken());
            int left = Math.min(a, b);
            int right = Math.max(a, b);
            System.out.println(getSum(left, right, s));
            edit(index, val, s);
        }
    }
    public static long getSum(int left, int right, int s){
        left = left + s - 1;
        right = right + s -1;
        long ret = 0;
        while(left <= right){
            if(left % 2 != 0){
                ret += arr[left];
                left++;
            }
            if(right % 2 == 0){
                ret += arr[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return ret;
    }

    public static void edit(int index, long val, int s){
        index = index + s - 1;
        arr[index] = val;
        int k = index / 2;
        while( k > 0){
            arr[k] = arr[k * 2] + arr[k * 2 + 1];
            k = k /2;
        }
    }
}
