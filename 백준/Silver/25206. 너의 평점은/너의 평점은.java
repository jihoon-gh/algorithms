
	import java.util.*;
	import java.io.*;
	import java.util.stream.Collectors;
	import java.io.*;
	
	
	public class Main {
		static Map<String, Double> hm = new HashMap<>();
		public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			hm.put("A+", 4.5);
			hm.put("A0", 4.0);
			hm.put("B+", 3.5);
			hm.put("B0", 3.0);
			hm.put("C+", 2.5);
			hm.put("C0", 2.0);
			hm.put("D+", 1.5);
			hm.put("D0", 1.0);
			hm.put("F", 0.0);
			double point = 0;
			double sum = 0;
			for(int i = 0; i < 20; i++) {
				String[] splits = br.readLine().split(" ");
				if(splits[2].equals("P")) continue;
				point += Double.parseDouble(splits[1]);
				sum += hm.get(splits[2]) * Double.parseDouble(splits[1]);
			}
			System.out.println(sum / point);
		}
	}
