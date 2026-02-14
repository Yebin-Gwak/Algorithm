import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] lists;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
			lists[e].add(s);
		}

		System.out.println(bfs(start, end));
	}

	private static int bfs(int start, int end) {
		int dist = 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(start);
		visited[start] = true;
		
		while(!dq.isEmpty()) {
			int T = dq.size();
			for(int t = 0; t < T; t++) {
				int now = dq.poll();
				if(now == end)
					return dist;
				for(int next : lists[now]) {
					if(!visited[next]) {
						visited[next] = true;
						dq.add(next);
					}
				}
			}
			dist++;
		}
		
		return -1;

	}
}