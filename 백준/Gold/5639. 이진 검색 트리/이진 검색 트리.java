import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int a){
            data = a;
            left = null;
            right = null;
        }
        public void insert(int k){
            if( data > k ){
                if(left == null){
                    left = new Node(k);
                }
                else{
                    left.insert(k);
                }
            }
            else{
                if(right==null){
                    right = new Node(k);
                }
                else{
                    right.insert(k);
                }
            }
        }
    }

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Node root = null;
        while((s = br.readLine())!=null && !s.isEmpty()){
            int k = Integer.parseInt(s);
            if(root == null){
                Node node = new Node(k);
                root = node;
                continue;
            }
            root.insert(k);
        }
        postOrder(root);
    }
    public static void postOrder(Node n){
        if(n == null){
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.data);
    }
}
