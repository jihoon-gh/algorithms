import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	

	static class Member{
		int level;
		String name;
		public Member(int a, String s) {
			level = a;
			name = s;
		}
	}
	static class Game{
		int min;
		int max;
		List<Member> members = new ArrayList<>();
		boolean isStart = false;
		
		public Game(Member member) {
			min = Math.max(0, member.level - 10);
			max = member.level + 10;
			members.add(member);
		}
	}
	
	static List<Game> glist = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());		
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			Member member = new Member(level, name);
			boolean isMemberProcessed = false;
			
			for(Game g : glist) {
				if(isMemberProcessed) break;
				if(g.isStart) continue;
				if(g.min <= level && g.max >= level) {
					g.members.add(member);
					isMemberProcessed = true;
					if(g.members.size() == m) g.isStart = true;
				}
				
			}
			if(!isMemberProcessed) {
				Game game = new Game(member);
				if(game.members.size() == m) {
					game.isStart = true;
				}
				glist.add(game);
			}
		}
		for(Game g : glist) {
			if(g.isStart) {
				System.out.println("Started!");
			}
			else {
				System.out.println("Waiting!");
			}
			List<Member> mlist = g.members;
			Collections.sort(mlist, new Comparator<Member>() {
				@Override
				public int compare(Member m1, Member m2) {
					return m1.name.compareTo(m2.name);
				}
			});
			for(Member member : mlist) {
				System.out.println(member.level + " " + member.name);
			}
		}
	}
}
