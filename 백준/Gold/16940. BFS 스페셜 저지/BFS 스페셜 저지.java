import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] rank;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		rank = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		System.out.println(bfs(new StringTokenizer(br.readLine())));
		
	}

	private static int bfs(StringTokenizer st) {
		if(Integer.parseInt(st.nextToken()) != 1)
			return 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		visited[1] = true;
		
		int idx = 2;
		while(!dq.isEmpty()) {
			int now = dq.poll();
			int cnt = 0;
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					rank[next] = idx;
					cnt++;
				}
			}
			
			for(int i = 0; i < cnt; i++) {
				int next = Integer.parseInt(st.nextToken());
				if(rank[next] != idx)
					return 0;
				dq.add(next);
			}
			
		}
		
		return 1;
	}

}
