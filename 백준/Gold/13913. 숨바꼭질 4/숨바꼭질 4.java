import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parents = new int[100001];
		parents[N] = N;
		
		search();
	}

	private static void search() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		
		deque.add(N);
		
		int time = 0;
		while(true) {
			int size = deque.size();
			for(int t = 0; t < size; t++) {
				int now = deque.poll();
				
				if(now == K) {
					sb.append(time + "\n");
					getRoute(K);
					System.out.println(sb.toString().trim());
					return;
				}
				
				if(now * 2 <= 100000 && !visited[now * 2]) {
					visited[now * 2] = true;
					parents[now * 2] = now;
					deque.add(now * 2);
				}
				if(0 <= now - 1 && !visited[now - 1]) {
					visited[now - 1] = true;
					parents[now - 1] = now;
					deque.add(now - 1);
				}
				if(now + 1 <= 100000 && !visited[now + 1]) {
					visited[now + 1] = true;
					parents[now+ 1] = now;
					deque.add(now + 1);
				}
			}
			time++;
			
		}
		
	}

	private static void getRoute(int now) {
		if(now != N)
			getRoute(parents[now]);
		sb.append(now + " ");
	}

}