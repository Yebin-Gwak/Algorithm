import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int dest;
		int distance;
		
		public Node(int dest, int distance) {
			super();
			this.dest = dest;
			this.distance = distance;
		}
		
	}
	
	static List<Node>[] list;
	static int N, M;
	static boolean[] visited;
	static boolean find;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N + 1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Node>();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			list[start].add(new Node(dest, distance));
			list[dest].add(new Node(start, distance));
		
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			visited = new boolean[N + 1];
			find = false;
			ans = 0;
			
			visited[start] = true;
			dfs(start, dest, 0);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
		
		
	}

	private static void dfs(int start, int dest, int sum) {
		if(start == dest) {
			find = true;
			ans = sum;
			return;
		}
		if(find)
			return;
		
		for(Node next : list[start]) {
			if(!visited[next.dest]) {
				visited[next.dest] = true;
				dfs(next.dest, dest, sum + next.distance);
				visited[next.dest] = false;
			}
		}
		
	}
}