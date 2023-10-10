import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int res = 0;
		for(int i = 0; i < n - 1; i++) {
			String tmp = br.readLine();
			if(isSimilar(s, tmp)) {
				res++;
			}
		}
		System.out.println(res);
	}
	public static boolean isSimilar(String s1, String s2) {
		
		if(s1.length() == s2.length()) {
			int[] arr1 = new int[26];
			char[] carr1 = s1.toCharArray();
			for(char c : carr1) {
				arr1[c - 'A']++;
			}
			//
			int[] arr2 = new int[26];
			char[] carr2 = s2.toCharArray();
			for(char c : carr2) {
				arr2[c - 'A']++;
			}
			
			int res = 0;
			for(int i = 0; i < 26; i++) {
				res += Math.abs(arr1[i] - arr2[i]);
			}
			if(res <= 2) return true;
			else return false;
		}
		else {
			if(Math.abs(s1.length() - s2.length()) >= 2) return false;
			int[] arr1 = new int[26];
			char[] carr1 = s1.toCharArray();
			for(char c : carr1) {
				arr1[c - 'A']++;
			}
			//
			int[] arr2 = new int[26];
			char[] carr2 = s2.toCharArray();
			for(char c : carr2) {
				arr2[c - 'A']++;
			}
			
			int res = 0;
			for(int i = 0; i < 26; i++) {
				res += Math.abs(arr1[i] - arr2[i]);
			}
			if(res <= 1) return true;
			else return false;
		}
	}
}
