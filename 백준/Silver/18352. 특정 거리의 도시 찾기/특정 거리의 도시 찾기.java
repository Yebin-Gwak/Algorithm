import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, K, V;
	static ArrayList<Integer>[] lists;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
		}
		bfs();
		
		if(ans.isEmpty()) {
			System.out.println(-1);
			return;
		}
		Collections.sort(ans);
		for(int n : ans) 
			sb.append(n + "\n");

		System.out.print(sb.toString());
	}

	private static void bfs() {
		boolean[] visited = new boolean[N + 1];
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		visited[V] = true;
		deque.add(V);
		
		while(K-- > 0) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				int now = deque.poll();
				for(int n : lists[now]) {
					if(!visited[n]) {
						visited[n] = true;
						deque.add(n);
					}
				}
			}
		}
		while(!deque.isEmpty())
			ans.add(deque.poll());
	}
}