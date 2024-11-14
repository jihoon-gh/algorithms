import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {
	static class Country {
		int num;
		int gold; 
		int silver; 
		int bronze; 
		int rank;
		public Country(int n, int a, int b, int c) {
			num = n;
			gold = a;
			silver = b;
			bronze = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Country> countries = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			countries.add(new Country(num, gold, silver, bronze));
		}
		Collections.sort(countries, new Comparator<>() {
			@Override
			public int compare(Country c1, Country c2) {
				if(c1.gold == c2.gold) {
					if(c1.silver == c2.silver) {
						return c2.bronze - c1.bronze;
					}
					return c2.silver - c1.silver;
				}
				return c2.gold - c1.gold;
				}
		});
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				countries.get(i).rank = i + 1;
			}
			else {
				if(isSameMedalNums(countries.get(i - 1), countries.get(i))) {
					countries.get(i).rank = countries.get(i - 1).rank;
				}
				else {
					countries.get(i).rank = i + 1;
				}
			}
			if(countries.get(i).num == m) {
				System.out.println(countries.get(i).rank);
				return ;
			}
		}
		
	}
	public static boolean isSameMedalNums(Country c1, Country c2) {
		if(c1.gold == c2.gold && c1.silver == c2.silver && c1.bronze == c2.bronze) return true;
		return false;
	}
}