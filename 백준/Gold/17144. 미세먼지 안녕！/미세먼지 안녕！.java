import java.util.*;
import java.io.*;

public class Main {
	static class Cleaner implements Comparable<Cleaner> {
		int x, y;

		public Cleaner(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Cleaner o) {
			return Integer.compare(this.x, o.x);
		}

	}

	static class Dust {
		int x, y, size, d;

		public Dust(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		public Dust(int x, int y, int size, int d) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.d = d;
		}
	}

	static int N, M, T;
	static int[][] map;

	static List<Integer> cleaner = new ArrayList<>();
	static Deque<Dust> dusts = new ArrayDeque<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value > 0)
					dusts.add(new Dust(i, j, value, -1));
				else if (value == -1) {
					map[i][j] = -1;
					cleaner.add(i);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			setDirection();
			clean();
			reset();
		}

		for (Dust dust : dusts)
			ans += dust.size;

		System.out.println(ans);

	}

	private static void spread() {
		int repeat = dusts.size();
		for (int i = 0; i < repeat; i++) {

			Dust dust = dusts.poll();
			int x = dust.x;
			int y = dust.y;
			int size = dust.size;
			int count = 0;

			if (size > 4) {
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != -1) {
						count++;
						map[nx][ny] += size / 5;
					}
				}
				map[x][y] += size - (size / 5 * count);

			} else
				map[x][y] += size;

		}

	}

	private static void setDirection() {

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] > 0) {
					int d = -1;
					if ((x == 0 || x == N - 1 || cleaner.contains(x) || y == 0 || y == M - 1)) {
						// x좌표가 위쪽 청소기의 청소 범위라면
						if (x <= cleaner.get(0)) {
							if (x == cleaner.get(0)) {
								if (y == M - 1)
									d = 0;
								else
									d = 1;
							} else if (y == M - 1) {
								if (x == 0)
									d = 3;
								else
									d = 0;
							} else if (x == 0) {
								if (y == 0)
									d = 2;
								else
									d = 3;
							} else if (y == 0) {
								d = 2;
							}

						}

						// x 좌표가 아래쪽 청소기의 청소 범위라면
						else {
							if (x == cleaner.get(1)) {
								if (y == M - 1)
									d = 2;
								else
									d = 1;
							} else if (y == M - 1) {
								if (x == N - 1)
									d = 3;
								else
									d = 2;
							} else if (x == N - 1) {
								if (y == 0)
									d = 0;
								else
									d = 3;
							} else if (y == 0) {
								d = 0;
							}

						}

					}
					dusts.add(new Dust(x, y, map[x][y], d));
					map[x][y] = 0;

				}

			}
		}

	}

	private static void clean() {
		int repeat = dusts.size();

		for (int k = 0; k < repeat; k++) {
			Dust dust = dusts.poll();
			if (dust.d != -1) {
				dust.x += dx[dust.d];
				dust.y += dy[dust.d];
			}

			if (map[dust.x][dust.y] == -1)
				continue;

			map[dust.x][dust.y] = dust.size;
			dusts.add(dust);

		}

	}

	private static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (map[i][j] > 0)
					map[i][j] = 0;
		}
	}

}
