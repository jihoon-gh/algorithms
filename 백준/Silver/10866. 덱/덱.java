import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] splits = br.readLine().split(" ");
            if(splits.length == 1){
                func(splits[0]);
                continue;
            }
            func(splits[0], Integer.parseInt(splits[1]));
        }
    }

    public static void func(String s, int x){
        if(s.equals("push_front")){
            deque.addFirst(x);
        }
        if(s.equals("push_back")){
            deque.addLast(x);
        }
    }
    public static void func(String s){
        if(s.equals("pop_front")){
            if(deque.isEmpty()){
                System.out.println(-1);
                return;
            }
            int a = deque.pollFirst();
            System.out.println(a);
        }
        if(s.equals("pop_back")){
            if(deque.isEmpty()){
                System.out.println(-1);
                return;
            }
            int a = deque.pollLast();
            System.out.println(a);
        }
        if(s.equals("size")){
            System.out.println(deque.size());
        }
        if(s.equals("empty")){
            if(deque.isEmpty()){
                System.out.println(1);
                return ;
            }
            System.out.println(0);
        }
        if(s.equals("front")){
            if(deque.isEmpty()){
                System.out.println(-1);
                return;
            }
            int a = deque.peekFirst();
            System.out.println(a);
        }
        if(s.equals("back")){
            if(deque.isEmpty()){
                System.out.println(-1);
                return;
            }
            int a = deque.peekLast();
            System.out.println(a);
        }
    }
}
