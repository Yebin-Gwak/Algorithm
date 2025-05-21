import java.util.*;
import java.io.*;

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
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, M;
	static int[][][] distances;
	static Node[] mans;
	static int[][] map;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		distances = new int[3][N][M];
		mans = new Node[3];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			mans[i] = new Node(x, y, 0);
		}
		
		for(int i = 0; i < 3; i++)
			dijkstra(i);
		
		calc();
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min + "\n" + cnt);
		
	}

	private static void dijkstra(int idx) {
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node n = mans[idx];
		int[][] distance = distances[idx];
		for(int i = 0; i < N; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		distance[n.x][n.y] = 0;
		pq.add(n);
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int x = now.x;
			int y = now.y;
			if(!visited[x][y])
				visited[x][y] = true;
			
			if(distances[idx][x][y] != now.cost)
				continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] 
						&& map[nx][ny] == 0 && now.cost + 1 < distance[nx][ny]) {
					distance[nx][ny] = now.cost + 1;
					pq.add(new Node(nx, ny, distance[nx][ny]));
				}
			}
			
		}
		
	}
	
	private static void calc() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					continue;
				int v = Math.max(distances[0][i][j], Math.max(distances[1][i][j], distances[2][i][j]));
				if(v == min)
					cnt++;
				else if(v < min) {
					min =v;
					cnt = 1;
				}
			}
		}
		
	}
}