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
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.add(new Node(i, j, map[i][j]));
			}
		}
		
		for(int i = 0; i < N; i++)
			Arrays.fill(dp[i], 1);
		
		bfs();
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				ans = Math.max(ans, dp[i][j]);
		}
		
		System.out.println(ans);
		
	}
	private static void bfs() {
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] > map[now.x][now.y])
					dp[nx][ny] = Math.max(dp[nx][ny], dp[now.x][now.y] + 1);
			}
		}
		
	}

}