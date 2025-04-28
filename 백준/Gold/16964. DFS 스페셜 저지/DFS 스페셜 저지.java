import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static HashSet<Integer>[] list;
	static boolean[] visited;
	static int[] rank;
	static int idx = 2;
	static int next = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new HashSet[N + 1];
		for(int i = 0; i <= N; i++)
			list[i] = new HashSet<>();
		visited = new boolean[N + 1];
		rank = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++)
			rank[i] = Integer.parseInt(st.nextToken());
		if(rank[1] != 1) {
			System.out.println(0);
			return;
		}
		visited[1] = true;
		next = rank[idx];
		dfs(1);
		System.out.println((idx == N) ? 1 : 0);
		
	}

	private static void dfs(int now) {
		while(idx <= N) {
			if(list[now].contains(rank[idx]) && !visited[rank[idx]]) {
				if(idx == N)
					return;
				visited[rank[idx]] = true;
				idx++;
				dfs(rank[idx - 1]);
			} else {
				for(int next : list[now]) {
					if(!visited[next]) {
						System.out.println(0);
						System.exit(0);
					}
				}
				return;
			}
		}
	}

}