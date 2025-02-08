import java.util.*;
import java.io.*;

public class Main {

	static HashMap<Integer, int[]> problems;
	static TreeSet<Integer>[] levels;
	static TreeSet<Integer>[][] types;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		problems = new HashMap<>();
		levels = new TreeSet[101];
		types = new TreeSet[101][101];
		for(int i = 0; i <= 100; i++) {
			levels[i] = new TreeSet<>();
			for(int j = 0; j <= 100; j++)
				types[i][j] = new TreeSet<>();
		}
		
		int p = 0;
		int l = 0;
		int g = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			add(p, l, g);
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			char c = cmd.charAt(0);
			
			if(c == 'a') {
				p = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				g = Integer.parseInt(st.nextToken());
				add(p, l, g);
				continue;
			}
			
			if(c == 's') {
				p = Integer.parseInt(st.nextToken());
				l = problems.get(p)[0];
				g = problems.get(p)[1];
				solved(p, l, g);
				continue;
			}
			
			int num = cmd.charAt(cmd.length() - 1);
			int v = Integer.parseInt(st.nextToken());
			
			if(num == 'd') {
				rec1(v, Integer.parseInt(st.nextToken()));
				continue;
			}
			
			if(num == '2') {
				rec2(v);
				continue;
			}
			
			rec3(v, Integer.parseInt(st.nextToken()));
		}
		System.out.print(sb.toString());
	}
	
	private static void add(int p, int l, int g) {
		levels[l].add(p);
		types[g][l].add(p);
		problems.put(p, new int[] {l, g});
	}
	
	private static void solved(int p, int l, int g) {
		levels[l].remove(p);
		types[g][l].remove(p);
		problems.remove(p);
	}


	private static void rec1(int g, int x) {
		if(x == 1) {
			for(int j = 100; j >= 1; j--) {
				if(types[g][j].isEmpty()) continue;
				sb.append(types[g][j].last() + "\n");
				return;
			}
		}else {
			for(int j = 1; j <= 100; j++) {
				if(types[g][j].isEmpty()) continue;
				sb.append(types[g][j].first() + "\n");
				return;
			}
		}
		
	}
	
	private static void rec2(int x) {
		if(x == 1) {
			for(int j = 100; j >= 1; j--) {
				if(levels[j].isEmpty()) continue;
				sb.append(levels[j].last() + "\n");
				return;
			}
		}else {
			for(int j = 1; j <= 100; j++) {
				if(levels[j].isEmpty()) continue;
				sb.append(levels[j].first() + "\n");
				return;
			}
		}
	}
	
	private static void rec3(int x, int l) {
		if(x == 1) {
			for(int j = l; j <= 100; j++) {
				if(levels[j].isEmpty()) continue;
				sb.append(levels[j].first() + "\n");
				return;
			}
			sb.append(-1 + "\n");
			
		}else {
			for(int j = l - 1; j >= 1; j--) {
				if(levels[j].isEmpty()) continue;
				sb.append(levels[j].last() + "\n");
				return;
			}
			sb.append(-1 + "\n");
		}
	}

}