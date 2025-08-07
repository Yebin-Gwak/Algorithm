import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int x, y, cost, mod;

		public Node(int x, int y, int cost, int mod) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.mod = mod;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	static int N, M, sX, sY, eX, eY;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sX = Integer.parseInt(st.nextToken()) - 1;
		sY = Integer.parseInt(st.nextToken()) - 1;
		eX = Integer.parseInt(st.nextToken()) - 1;
		eY = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dijkstra());
	}
	
	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][][] visited = new boolean[N][M][3];
		int[][][] distances = new int[N][M][3];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				Arrays.fill(distances[i][j], Integer.MAX_VALUE);
		}
		distances[sX][sY][0] = 0;
		pq.add(new Node(sX, sY, 0, 0));
		int[] dx = new int[] {1, -1, 0, 0};
		int[] dy = new int[] {0, 0, 1, -1};
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int x = now.x;
			int y = now.y;
			int m = now.mod;
			int nm = (m + 1) % 3;
			
			if(x == eX && y == eY)
				return now.cost;
			
			if(now.cost != distances[x][y][m])
				continue;
			
			if(!visited[x][y][m])
				visited[x][y][m] = true;
			
			for(int i = 0; i < 4; i++) {
				if(nm == 1 && (i == 2 || i == 3))
					continue; 
				if(nm == 2 && (i == 0 || i == 1))
					continue;
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny][nm] && map[nx][ny] != -1 &&
						now.cost + map[nx][ny] < distances[nx][ny][nm]) {
					distances[nx][ny][nm] = now.cost + map[nx][ny];
					pq.add(new Node(nx, ny, distances[nx][ny][nm], nm));
				}
				
			}
		}
		
		return -1;
	}
}
