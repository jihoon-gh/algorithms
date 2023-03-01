import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			String narr = br.readLine();
			narr = narr.substring(1, narr.length() - 1);
			String[] splits = narr.split(",");
			
			ArrayDeque<Integer> arr = new ArrayDeque<>();
			if(splits.length != 0) {
				for(String temp : splits) {
					if(temp.isEmpty()) continue;
					arr.add(Integer.parseInt(temp));
				}
			}
			
			boolean checker = true;
			boolean isBreak = false;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'R') {
					checker = !checker;
					continue;
				}
				if(s.charAt(i) == 'D') {
					if(n == 0) {
						System.out.println("error");
						isBreak = true;
						break;
					}
					else {
						n--;
						if(checker) {
							arr.removeFirst();
						}
						else {
							arr.removeLast();
						}
					}
				}
			}
			if(isBreak) continue;
			StringBuilder sb = new StringBuilder();
			if(!checker) {
				sb.append('[');
				while(arr.size() > 1) {
					int x = arr.pollLast();
					sb.append(x);
					sb.append(',');
				}
				if(arr.size()==1) {
					sb.append(arr.poll());
				}
				sb.append(']');
			}else {
				sb.append('[');
				while(arr.size() > 1) {
					int x = arr.pollFirst();
					sb.append(x);
					sb.append(',');
				}
				if(arr.size()==1) {
					sb.append(arr.poll());
				}
				sb.append(']');
			}
			System.out.println(sb);
		}
	}
}
