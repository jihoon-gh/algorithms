import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static class Node{
		Map<Character, Node> childs;
		boolean isEnd;
		
		public Node() {
			childs = new HashMap<>();
			isEnd = false;
		}
	}
	static class Trie{
		Node root;
		public Trie() {
			root = new Node();
		}
		public void insert(String str) {
			Node node = this.root;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				node.childs.putIfAbsent(c, new Node());
				node = node.childs.get(c);
			}
			node.isEnd = true;
		}
		public boolean search(String str) {
			Node node = root;
			boolean isPrefix = true;
			for(int i = 0; i < str.length(); i++) {
				if(!isPrefix) return isPrefix;
				char c = str.charAt(i);
				
				if(node.childs.containsKey(c)) {
					node = node.childs.get(c);
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
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			List<String> ls = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				String tmp = br.readLine();
				ls.add(tmp);
			}
			Collections.sort(ls, new Comparator<>() {
				@Override
				public int compare(String s1, String s2) {
					return s2.length() - s1.length();
				}
			});
			boolean ans = true;
			Trie trie = new Trie();
			for(String s : ls) {
				if(!trie.search(s)) trie.insert(s);
				else ans = false;
				if(!ans) break;
			}
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}