import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String k = st.nextToken();
		int m = 0;
		if(k.equals("Y")) {
			m = 2;
		}
		if(k.equals("F")) {
			m = 3;
		}
		if(k.equals("O")) {
			m = 4;
		}
		Set<String> s = new HashSet<>();
		for(int i = 0; i < n; i++) {
			s.add(br.readLine());
		}
		System.out.println(s.size() / (m - 1));		
	}
}
