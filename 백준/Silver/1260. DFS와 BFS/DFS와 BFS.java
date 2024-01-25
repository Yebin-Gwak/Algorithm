import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
			
		}
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb.toString());
		

	}
	
	
	private static void dfs(int start) {
		sb.append(start + " ");
		visited[start] = true;
		for(int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false)
				dfs(i);
		}
	}
	
	private static void bfs(int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		sb.append(start + " ");
		visited[start] = true;
		deque.addFirst(start);
		
		while(!deque.isEmpty()) {
			int x = deque.pollFirst();
			for(int i = 1; i < arr.length; i++) {
				if(arr[x][i] == 1 && visited[i] == false) {
					sb.append(i + " ");
					visited[i] = true;
					deque.addLast(i);
					
				}
			}
		}
		
	}

}