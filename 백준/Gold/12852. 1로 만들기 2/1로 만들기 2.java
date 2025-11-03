import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		System.out.println(bfs(N));
		find(1);
		System.out.println(sb.toString().trim());
	}
	
	private static void find(int now) {
		sb.insert(0, now + " ");
		if(now == N)
			return;
		find(parents[now]);
	}

	private static int bfs(int N) {
		boolean[] visited = new boolean[N + 1];
		int cnt = 0;
		visited[N] = true;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(N);
		while(true) {
			int size = dq.size();
			for(int i = 0; i < size; i++) {
				int now = dq.poll();
				if(now == 1)
					return cnt;
				
				if(now % 3 == 0 && !visited[now / 3]) {
					int next = now / 3;
					visited[next] = true;
					dq.add(next);
					parents[next] = now;
				}
				if(now % 2 == 0 && !visited[now / 2]) {
					int next = now / 2;
					visited[next] = true;
					dq.add(next);
					parents[next] = now;
				}
				if(now - 1 > 0 && !visited[now - 1]) {
					int next = now - 1;
					visited[next] = true;
					dq.add(next);
					parents[next] = now;
				}
				
			}
			
			cnt++;
		}
	}
}
