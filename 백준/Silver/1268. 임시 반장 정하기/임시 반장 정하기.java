import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][6];
		Set<Integer>[][] sets = new HashSet[6][10];
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 9; j++) {
				sets[i][j] = new HashSet<>();
			}
		}
		//
		for(int i = 1; i <= n; i++) { // 학생 번호
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 5; j++) { // 학생 학년
				int x = Integer.parseInt(st.nextToken());
				arr[i][j] = x; // i번 학생의 j 학년 때 반
				sets[j][x].add(i); 
				
			}
		}
		//
		int num = 0;
		int max = 0;
		for(int i = 1; i <= n; i++) {
			Set<Integer> tmp = new HashSet<>();
			for(int j = 1; j <= 5; j++) {
				int x = arr[i][j];
				tmp.addAll(sets[j][x]);
			}
			if(max < tmp.size()) {
				max = tmp.size();
				num = i;
			}
		}
		System.out.println(num);
	}
}