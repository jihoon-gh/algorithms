

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            String[] splits = br.readLine().split(" ");
            nums.add(Integer.parseInt(splits[0]));
            nums.add(Integer.parseInt(splits[1]));
        }
        int x = nums.get(0) * nums.get(3) + nums.get(1) * nums.get(2);
        int y = nums.get(1) * nums.get(3);

        int k = gcd(x, y);
        StringBuilder sb = new StringBuilder();
        sb.append(x/k);
        sb.append(" ");
        sb.append(y/k);
        System.out.println(sb);
    }

    public static int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}