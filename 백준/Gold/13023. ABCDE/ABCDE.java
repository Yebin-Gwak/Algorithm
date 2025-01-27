import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Integer>[] list;
	static int N;
	static int M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);		
		}
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		System.out.println(0);
	}
	private static void dfs(int n, int cnt) {
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		for(int next : list[n]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
}