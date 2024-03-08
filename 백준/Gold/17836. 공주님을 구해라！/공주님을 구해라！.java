import java.util.*;
import java.io.*;

public class Main {
	static class Hero {
		int x, y, t;
		int sword;

		public Hero(int x, int y, int t, int sword) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.sword = sword;
		}
	}

	static int N, M, T;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Deque<Hero> q = new ArrayDeque<>();
		q.add(new Hero(0, 0, 0, 0));
		visited[0][0][0] = true;
		int time = -1;
		while (!q.isEmpty()) {
			Hero cur = q.poll();
			if (cur.t > T)
				continue;
			if ((cur.x == N - 1) && (cur.y == M - 1)) {
				time = cur.t;
				break;
			}
			for (int idx = 0; idx < 4; idx++) {
				int mx = cur.x + dx[idx];
				int my = cur.y + dy[idx];
				int hasSword = cur.sword;

				if (!isValid(mx, my))
					continue;
				if (hasSword == 0) {
					if (visited[mx][my][0] || map[mx][my] == 1)
						continue;
					if (map[mx][my] == 2)
						hasSword++;

				}

				else {
					if (visited[mx][my][1])
						continue;
				}
				visited[mx][my][hasSword] = true;
				q.add(new Hero(mx, my, cur.t + 1, hasSword));

			}
		}
		System.out.print(time < 0 ? "Fail" : time);
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}