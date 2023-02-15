import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {


    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        b1 = b1.add(b2);
        System.out.println(b1);
    }
}
