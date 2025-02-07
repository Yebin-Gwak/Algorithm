import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> problems = new HashMap<>();
		TreeSet<Integer>[] levels = new TreeSet[101];
		for(int i = 0; i <= 100; i++)
			levels[i] = new TreeSet<>();
		
		int p = 0;
		int l = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			levels[l].add(p);
			problems.put(p, l);
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			
			if(cmd == 'a') {
				p = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				levels[l].add(p);
				problems.put(p, l);
				continue;
			}
			
			if(cmd == 's') {
				p = Integer.parseInt(st.nextToken());
				l = problems.get(p);
				levels[l].remove(p);
				problems.remove(p);
				continue;
			}
			
			if(cmd == 'r') {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					for(int j = 100; j >= 1; j--) {
						if(levels[j].isEmpty()) continue;
						sb.append(levels[j].last() + "\n");
						break;
					}
				}else {
					for(int j = 1; j <= 100; j++) {
						if(levels[j].isEmpty()) continue;
						sb.append(levels[j].first() + "\n");
						break;
					}
				}
			}
		}
		System.out.print(sb.toString());
	}
}