import java.io.*;
import java.util.*;

public class Main {
	
	static class Pair{
		int x;
		int y;
		Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	static List<Pair> students = new ArrayList<>();
	static List<Pair> teachers = new ArrayList<>();
	static List<Pair> emptySeats = new ArrayList<>();
	
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if(arr[i][j] == 'T') {
					teachers.add(new Pair(i, j));
				}
				else if(arr[i][j] == 'S') {
					students.add(new Pair(i, j));
				}
				else {
					emptySeats.add(new Pair(i, j));
				}
			}
		}
		for(int i = 0; i < emptySeats.size() - 2; i++) {
			for(int j = i + 1; j < emptySeats.size() - 1; j++) {
				for(int k = j + 1; k < emptySeats.size(); k++) {
					visited = new boolean[n][n];
					Pair p1 = emptySeats.get(i);
					Pair p2 = emptySeats.get(j);
					Pair p3 = emptySeats.get(k);
					arr[p1.x][p1.y] = 'O';
					arr[p2.x][p2.y] = 'O';
					arr[p3.x][p3.y] = 'O';
					for(Pair t : teachers) {
						check(t);
					}
					if(check()) {
						System.out.println("YES");
						return ;
					}
					arr[p1.x][p1.y] = 'X';
					arr[p2.x][p2.y] = 'X';
					arr[p3.x][p3.y] = 'X';
				}
			}
		}
		System.out.println("NO");
		
	}
	public static void check(Pair p) {
		int x = p.x;
		int y = p.y;
		for(int i = x; i < n; i++) {
			if(arr[i][y] == 'O') break;
			visited[i][y] = true;
		}
		for(int i = x; i >= 0; i--) {
			if(arr[i][y] == 'O') break;
			visited[i][y] = true;
		}
		
		for(int i = y; i < n; i++) {
			if(arr[x][i] == 'O') break;
			visited[x][i] = true;
		}
		for(int i = y; i >= 0; i--) {
			if(arr[x][i] == 'O') break;
			visited[x][i] = true;
		}
	}
	public static boolean check() {
		int res = 0;
		for(Pair s : students) {
			if(!visited[s.x][s.y]) res++;
		}
		if(res == students.size()) {
			return true;
		}
		return false;
	}
}