import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		ans = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
			lists[e].add(s);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(lists[i]);

		bfs(start);
		for(int i = 1; i <= N; i++)
			sb.append(ans[i] + "\n");
		System.out.println(sb);
	}

	private static void bfs(int start) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		visited[start] = true;
		int idx = 1;

		while (!dq.isEmpty()) {
			int now = dq.poll();
			ans[now] = idx++;
			for (int next : lists[now]) {
				if (!visited[next]) {
					visited[next] = true;
					dq.add(next);
				}
			}
		}
	}
}