import java.util.*;
import java.io.*;

public class Main {
	static class Pos implements Comparable<Pos>{
		int x, y, size;

		public Pos(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Pos o) {
			return this.size - o.size;
		}
		
		
	}
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				pq.add(new Pos(i, j, value));
			}
		}
		
		calc();
		search();

		System.out.println(ans + 1);
	}


	private static void calc() {
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			int x = now.x;
			int y = now.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] > map[x][y] && dp[nx][ny] <= dp[x][y])
					dp[nx][ny] = dp[x][y] + 1;
			}
		}
		
	}
	
	private static void search() {
		for(int[] x : dp) {
			for(int d : x) {
				ans = Math.max(ans, d);
			}
		}
	}

}
