import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.io.*;


public class Main {
	static List<Integer> numberList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int ansValue = 0;
		for(int i = 0; i < n; i++) {
			numberList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				numberList.add(Integer.parseInt(st.nextToken()));
			}
			int tmp = getRes();
			if(ansValue <= tmp) {
				ansValue = tmp;
				ans = i + 1;
			}
		}
		System.out.println(ans);
	}
	public static int getRes() {
		int res = 0;
		for(int i = 0; i < numberList.size() - 2;i++) {
			for(int j = i+1; j < numberList.size() - 1; j++) {
				for(int k = j+1; k < numberList.size(); k++) {
					int tmp = numberList.get(i) + numberList.get(j) + numberList.get(k);
					res = Math.max(res, tmp % 10);
				}
			}
		}
		return res;
	}
}
