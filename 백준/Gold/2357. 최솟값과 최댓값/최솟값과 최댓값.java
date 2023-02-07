import java.util.*;
import java.io.*;

public class Main {

    static int[] arrMin;
    static int[] arrMax;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = 1;
        while(s < n) {
            s <<= 1;
        }
        arrMin = new int[2*s];
        arrMax = new int[2*s];

        for(int i = 1; i <= 2 * s -1; i++){
            arrMin[i] = 2000000000;
        }

        for(int i = s; i <= s + n -1; i++) {
            int k = Integer.parseInt(br.readLine());
            arrMin[i] = k;
            arrMax[i] = k;
        }
        for(int i = s; i <= 2 * s - 1;i++){
            int k = i / 2;
            while(k > 0){
                arrMin[k] = Math.min(arrMin[k * 2], arrMin[k * 2 +1]);
                arrMax[k] = Math.max(arrMax[k * 2], arrMax[k * 2 +1]);
                k /= 2;
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int ansMin = getMin(left, right, s);
            int ansMax = getMax(left, right, s);
            System.out.println(ansMin + " " + ansMax);
        }
    }

    public static int getMin(int left, int right,int s) {

        left = left + s - 1;
        right = right + s - 1;
        int res = 2000000000;
        while(left <= right) {
            if(left % 2 != 0) {
                res = Math.min(res, arrMin[left]);
                left++;
            }
            if(right % 2 == 0) {
                res = Math.min(res, arrMin[right]);
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return res;
    }

    public static int getMax(int left ,int right, int s){
        left = left + s - 1;
        right = right + s - 1;
        int res = 0;
        while(left <= right) {
            if(left % 2 != 0) {
                res = Math.max(res, arrMax[left]);
                left++;
            }
            if(right % 2 == 0) {
                res = Math.max(res, arrMax[right]);
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return res;
    }
}
