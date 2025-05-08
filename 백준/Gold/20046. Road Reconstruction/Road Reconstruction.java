import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	static int N, M;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1)
					visited[i][j] = true;
				else
					map[i][j] = n;
			}
		}
		
		System.out.println(dijkstra());
		
	}

	private static int dijkstra() {
		if(visited[0][0] || visited[N - 1][M - 1])
			return -1;
		
		int[][] distances = new int[N][M];
		for(int i = 0; i < N; i++)
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distances[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.x == N - 1 && now.y == M - 1)
				return now.cost;
			
			if(now.cost > distances[now.x][now.y])
				continue;
			
			if(!visited[now.x][now.y])
				visited[now.x][now.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && now.cost + map[nx][ny] < distances[nx][ny]) {
					distances[nx][ny] = now.cost + map[nx][ny];
					pq.add(new Node(nx, ny, distances[nx][ny]));
				}
			}
			
		}
		
		return -1;
	}

}