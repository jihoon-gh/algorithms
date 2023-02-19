import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            if(maxQ.size() == minQ.size()){
                maxQ.add(k);
            }
            else{
                minQ.add(k);
            }
            if(!minQ.isEmpty() &&!maxQ.isEmpty()&& maxQ.peek() > minQ.peek()){
                int a = maxQ.poll();
                int b = minQ.poll();
                minQ.add(a);
                maxQ.add(b);
            }
            bw.write(maxQ.peek()+""+'\n');
        }
        bw.flush();
    }
}
