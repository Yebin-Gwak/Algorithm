import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static char[][] map;
	static int[][] ground;

	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static List<int[]> pieces = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		ground = new int[N][M];

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);
			}
		}
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		boolean left = true;
		for (int i = 0; i < K; i++) {
			int h = Integer.parseInt(st.nextToken());
			shoot(left, N - h);
			check();
			left = !left;
		}

		for (char[] r : map) {
			for (char c : r)
				sb.append(c);
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}

	private static void shoot(boolean left, int x) {
		int y = left ? 0 : M - 1;
		int d = left ? 1 : -1;

		while (-1 < y && y < M) {
			if (map[x][y] == 'x') {
				map[x][y] = '.';
				break;
			}
			y += d;
		}
	}

	private static void check() {
		ground = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < M; i++) {
			if (map[N - 1][i] == 'x' && !visited[N - 1][i])
				bfs(N - 1, i, true);
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'x' && !visited[i][j]) {
					bfs(i, j, false);
					move(findHeight());
					pieces.clear();
					return;
				}
			}
		}

	}

	private static void bfs(int startX, int startY, boolean earth) {
		if (earth)
			ground[startX][startY] = -1;
		else {
			map[startX][startY] = '.';
			pieces.add(new int[] { startX, startY });
		}

		Deque<int[]> deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		deque.add(new int[] { startX, startY });

		while (!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 'x' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] { nx, ny });
					
					if (earth)
						ground[nx][ny] = -1;
					else {
						map[nx][ny] = '.';
						pieces.add(new int[] { nx, ny });
					}
				}
			}
		}

	}

	private static int findHeight() {
		int h = 0;
		while (true) {
			h++;
			boolean hitMineral = false;
			boolean hitGround = false;
			for (int[] v : pieces) {
				int x = v[0];
				int y = v[1];
				if (ground[x + h][y] == -1)
					hitMineral = true;
				if (x + h == N - 1)
					hitGround = true;
			}
			if (hitMineral)
				return h - 1;
			if (hitGround)
				return h;

		}

	}

	private static void move(int h) {
		for (int[] v : pieces) {
			int x = v[0];
			int y = v[1];
			map[x + h][y] = 'x';
		}
	}

}