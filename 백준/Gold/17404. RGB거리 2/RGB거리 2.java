import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static int[] rsnr = new int[1001];
    static int[] rsng = new int[1001];
    static int[] rsnb = new int[1001];
    static int[] gsnr = new int[1001];
    static int[] gsng = new int[1001];
    static int[] gsnb = new int[1001];
    static int[] bsnr = new int[1001];
    static int[] bsng = new int[1001];
    static int[] bsnb = new int[1001];

    static int[] red = new int[1001];
    static int[] green = new int[1001];
    static int[] blue = new int[1001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<=1000;i++){
            rsnr[i] = 1001;
            rsnb[i] = 1001;
            rsng[i] = 1001;

            bsnr[i] = 1001;
            bsnb[i] = 1001;
            bsng[i] = 1001;

            gsnr[i] = 1001;
            gsnb[i] = 1001;
            gsnb[i] = 1001;
        }

        rsnr[1] = red[1];
        gsng[1] = green[1];
        bsnb[1] = blue[1];

        for(int i = 2; i <= n-1; i++){
            rsnb[i] = Math.min(rsnr[i-1], rsng[i-1]) + blue[i];
            rsnr[i] = Math.min(rsnb[i-1], rsng[i-1]) + red[i];
            rsng[i] = Math.min(rsnb[i-1], rsnr[i-1]) + green[i];

            bsnb[i] = Math.min(bsnr[i-1], bsng[i-1]) + blue[i];
            bsnr[i] = Math.min(bsnb[i-1], bsng[i-1]) + red[i];
            bsng[i] = Math.min(bsnr[i-1], bsnb[i-1]) + green[i];

            gsnb[i] = Math.min(gsnr[i-1], gsng[i-1]) + blue[i];
            gsnr[i] = Math.min(gsng[i-1], gsnb[i-1]) + red[i];
            gsng[i] = Math.min(gsnr[i-1], gsnb[i-1]) + green[i];
        }
        rsnb[n] = Math.min(rsnr[n-1], rsng[n-1]) + blue[n];
        rsng[n] = Math.min(rsnb[n-1], rsnr[n-1]) + green[n];

        bsnr[n] = Math.min(bsnb[n-1], bsng[n-1]) + red[n];
        bsng[n] = Math.min(bsnr[n-1], bsnb[n-1]) + green[n];

        gsnb[n] = Math.min(gsnr[n-1], gsng[n-1]) + blue[n];
        gsnr[n] = Math.min(gsng[n-1], gsnb[n-1]) + red[n];

        List<Integer> nums = new ArrayList<>();
        nums.add(rsnb[n]);
        nums.add(rsng[n]);
        nums.add(gsnb[n]);
        nums.add(gsnr[n]);
        nums.add(bsnr[n]);
        nums.add(bsng[n]);
        int k = Collections.min(nums);
        System.out.println(k);
    }
}
