import java.io.*;
import java.util.*;

public class Main {

	static class Food{
		int protein;
		int fat;
		int carb;
		int vitamin;
		int price;
		public Food(int a, int b, int c, int d, int e) {
			protein = a;
			fat = b;
			carb = c;
			vitamin = d;
			price = e;
		}
	}
	static int curr = 2000000000;
	static Food[] arr;
	static Food target;
	static int n;
	static ArrayDeque<Integer> ad = new ArrayDeque<>();
	static List<List<Integer>> alist = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e;
		target = new Food(a, b, c, d, 0);
		arr = new Food[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			arr[i] = new Food(a, b, c, d, e);
		}
		for(int i = 0; i < n; i++) {
			ad.addLast(i);
			dfs(i);
			ad.pollLast();
		}
		if(alist.size() == 0) {
			System.out.println(-1);
			return ;
		}
		Collections.sort(alist, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				for(int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
					if(l1.get(i) > l2.get(i)) {
						return 1;
					}
				}
				if(l1.size() > l2.size()) {
					return 1;
				}
				return -1;
			}
		});
		
		List<Integer> ansList = alist.get(0);
		System.out.println(curr);
		for(int i = 0; i < ansList.size(); i++) {
			System.out.print(ansList.get(i)+ 1 + " ");
		}
	}
	public static void dfs(int k) {
		if(isValid()) {
			List<Integer> tmp = new ArrayList<>();
			int p = 0;
			for(int i : ad) {
				tmp.add(i);
				p += arr[i].price;
			}
			if(p < curr) {
				alist.clear();
				alist.add(tmp);
				curr = p;
				return;
			}
			if( p == curr) {
				alist.add(tmp);
				return ;
			}
		}

		for(int i = k + 1; i < n; i++) {
			ad.addLast(i);
			dfs(i);
			ad.pollLast();
		}
	}
	public static boolean isValid() {
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		for(int i : ad) {
			a += arr[i].protein;
			b += arr[i].fat;
			c += arr[i].carb;
			d += arr[i].vitamin;
			e += arr[i].price;
		}
		if(target.protein <= a && target.fat <= b && target.carb <= c && target.vitamin <= d) {
			return true;
		}
		return false;
	}
}
