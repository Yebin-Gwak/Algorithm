import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		RSystem rs = new RSystem();
		int p = 0;
		int l = 0;
		int g = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			rs.add(p, l, g);
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
				rs.add(p, l, g);
				continue;
			}
			
			if(c == 's') {
				p = Integer.parseInt(st.nextToken());
				rs.solved(p);
				continue;
			}
			
			int num = cmd.charAt(cmd.length() - 1);
			int v = Integer.parseInt(st.nextToken());
			
			if(num == 'd') 
				rs.rec1(v, Integer.parseInt(st.nextToken()));
			else if(num == '2') 
				rs.rec2(v);
			else 
				rs.rec3(v, Integer.parseInt(st.nextToken()));
			
		}
		System.out.print(rs.toString());
	}
	
	static class RSystem{
		HashMap<Integer, int[]> problems = new HashMap<>();
		TreeSet<Integer>[] levels = new TreeSet[101];
		TreeSet<Integer>[][] types = new TreeSet[101][101];
		StringBuilder sb = new StringBuilder();
		
		public RSystem(){
			for(int i = 0; i <= 100; i++) {
				levels[i] = new TreeSet<>();
				for(int j = 0; j <= 100; j++)
					types[i][j] = new TreeSet<>();
			}
		}
		
		public void add(int p, int l, int g) {
			levels[l].add(p);
			types[g][l].add(p);
			problems.put(p, new int[] {l, g});
		}
		
		public void solved(int p) {
			int l = problems.get(p)[0];
			int g = problems.get(p)[1];
			
			levels[l].remove(p);
			types[g][l].remove(p);
			problems.remove(p);
		}
		
		public void rec1(int g, int x) {
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
		
		public void rec2(int x) {
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
		
		public void rec3(int x, int l) {
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
		
		public String toString() {
			return sb.toString();
		}
		
	}

}
