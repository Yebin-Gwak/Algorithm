import java.util.*;
import java.io.*;

public class Main {
	static class Pos implements Comparable<Pos> {
		int x, y, size;

		public Pos(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Pos o) {
			return o.size - this.size;
		}

	}

	static int N, M;
	static PriorityQueue<Pos> pq = new PriorityQueue<>();
	static int[][] map;
	static int[][] dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pq.add(new Pos(0, 0, map[0][0]));
		dp[0][0] = 1;

		calc();
		System.out.println(dp[N - 1][M - 1]);
	}

	private static void calc() {
		while (!pq.isEmpty()) {
			Pos now = pq.poll();
			int x = now.x;
			int y = now.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[x][y] > map[nx][ny]) {
					if (dp[nx][ny] == 0)
						pq.add(new Pos(nx, ny, map[nx][ny]));
					dp[nx][ny] += dp[x][y];
				}
			}
		}

	}

}