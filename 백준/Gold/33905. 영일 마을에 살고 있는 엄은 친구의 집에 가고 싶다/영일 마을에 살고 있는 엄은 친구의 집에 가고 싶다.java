import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static ArrayList<Integer>[] lists;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		lists = new ArrayList[N + 2];
		for(int i = 0; i <= N + 1; i++)
			lists[i] = new ArrayList<>();
		visited = new boolean[N + 2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
			lists[e].add(s);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++)
			visited[Integer.parseInt(st.nextToken())] = true;
		System.out.println(bfs());
		
	}
	private static int bfs() {
		int ans = 0;
		visited[1] = true;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		while(!dq.isEmpty()) {
			int now = dq.poll();
			for(int next : lists[now]) {
				if(!visited[next]) {
					visited[next] = true;
					dq.add(next);
					ans++;
				}
			}
		}
		return ans;
		
	}
}