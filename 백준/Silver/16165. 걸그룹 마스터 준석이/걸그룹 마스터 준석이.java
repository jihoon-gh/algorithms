import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, List<String>> girlGroups = new HashMap<>();
		Map<String, String> finder = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			int k = Integer.parseInt(br.readLine());
			List<String> names = new ArrayList<>();
			for(int j = 0; j < k; j++) {
				String name = br.readLine();
				names.add(name);
				finder.put(name, s);
			}
			girlGroups.put(s, names);
		}
		
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			int quizCase = Integer.parseInt(br.readLine());
			
			if(quizCase == 1) {
				String groupName = finder.get(s);
				System.out.println(groupName);
			}
			else {
				List<String> names = girlGroups.get(s);
				Collections.sort(names);
				for(String name : names) {
					System.out.println(name);
				}
			}
		}
	}
		
}
