import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		Map<Character, Node> children;
		boolean isEnd;
		public Node() {
			children = new HashMap<>();
			isEnd = false;
		}
	}
	static class Trie{
		Node root;
		
		public Trie() {
			root = new Node();
		}
		
		public void insert(String str) {
			Node node = root;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				node.children.putIfAbsent(c, new Node());
				node = node.children.get(c);
			}
			node.isEnd = true;
		}
		public boolean search(String str) {
			Node node = root;
			boolean isPrefix = true;
			for(int i = 0; i < str.length(); i++) {
				if(!isPrefix) return false;
				char c = str.charAt(i);
				
				if(node.children.containsKey(c)) {
					node = node.children.get(c);
				}
				else {
					isPrefix = false;
				}
			}
			return isPrefix;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		for(int i = 0; i < n; i++) {
			trie.insert(br.readLine());
		}
		int res = 0;
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			if(trie.search(str)) res++;
		}
		System.out.println(res);
	}
}

