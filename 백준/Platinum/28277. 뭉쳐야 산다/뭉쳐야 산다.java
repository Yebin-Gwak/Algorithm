import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		HashSet<Integer>[] sets = new HashSet[N + 1];
		for(int i = 0; i <= N; i++)
			sets[i] = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens())
				sets[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 2) {
				sb.append(sets[Integer.parseInt(st.nextToken())].size()).append("\n");
				continue;
			}
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(sets[a].size() >= sets[b].size()) {
				for(int n : sets[b])
					sets[a].add(n);
				sets[b].clear();
			}else {
				for(int n : sets[a])
					sets[b].add(n);
				sets[a].clear();
				HashSet<Integer> temp = sets[a];
				sets[a] = sets[b];
				sets[b] = temp;
			}
		}
		
		System.out.print(sb.toString());
		
	}

}