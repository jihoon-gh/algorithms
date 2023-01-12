
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] ways = new int[n-1];
        int[] cities = new int[n];

        String[] splits = br.readLine().split(" ");
        for(int i = 0; i < n-1; i++){
            ways[i] = Integer.parseInt(splits[i]);
        }

        splits = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            cities[i] = Integer.parseInt(splits[i]);
        }

        int price = 2000000000;
        long result = 0;
        for(int i = 0 ; i < n-1; i++)
        {
            price = Math.min(price, cities[i]);
            result += price * ways[i];
        }
        System.out.println(result);
    }
}
