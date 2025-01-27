import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
			lists[e].add(s);
		}
		for(ArrayList list : lists)
			Collections.sort(list);
		
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
	}


	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for(int n : lists[v]) {
			if(!visited[n])
				dfs(n);
		}
	}
	
	private static void bfs(int v) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		visited[v] = true;
		deque.add(v);
		sb.append(v + " ");
		
		while(!deque.isEmpty()) {
			int num = deque.poll();
			for(int n : lists[num]) {
				if(!visited[n]) {
					visited[n] = true;
					deque.add(n);
					sb.append(n + " ");
				}
			}
		}
	}
}