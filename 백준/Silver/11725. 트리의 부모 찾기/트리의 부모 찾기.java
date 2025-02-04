import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		ans = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[a].add(b);
			lists[b].add(a);
		}
		
		visited[1] = true;
		dfs(1);
		
		for(int i = 2; i <= N; i++)
			sb.append(ans[i] + "\n");
		System.out.print(sb.toString());

	}

	private static void dfs(int before) {
		for(int next : lists[before]) {
			if(!visited[next]) {
				visited[next] = true;
				ans[next] = before;
				dfs(next);
			}
		}
	}

}