import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int x, y, cost;

		public Node(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	static int N;
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		distance = new int[N][N];
		for(int i = 0; i < N; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}
		
		dijkstra();
		System.out.println(distance[N - 1][N - 1]);
		
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0]));
		distance[0][0] = (map[0][0] == 1) ? 0 : 1;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.x][now.y])
				visited[now.x][now.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(valid(nx, ny) && !visited[nx][ny] && 
						distance[nx][ny] > distance[now.x][now.y] + ((map[nx][ny] == 1) ? 0 : 1)) {
					distance[nx][ny] = distance[now.x][now.y] + ((map[nx][ny] == 1) ? 0 : 1);
					pq.add(new Node(nx, ny, distance[nx][ny]));
				}
			}
		}
		
	}

	private static boolean valid(int nx, int ny) {
		if(0 <= nx && nx < N && 0 <= ny && ny < N)
			return true;
		return false;
	}
}
