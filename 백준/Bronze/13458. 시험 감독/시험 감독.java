
import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String[] splits = s.split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(splits[i]);
        }
        s = br.readLine();
        String[] manager = s.split(" ");
        int a = Integer.parseInt(manager[0]);
        int b = Integer.parseInt(manager[1]);
        long answer = 0;
        for(int k : arr){
            if(k==0) break;
            if(k<=a){
                answer++;
            }
            if(k>a){
                answer++;
                int temp = k - a;
                if(temp % b == 0){
                    answer += temp/b;
                    continue;
                }
                answer += temp/b +1;
            }
        }
        System.out.println(answer);
    }
}