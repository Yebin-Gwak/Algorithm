import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, startX, startY, count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Deque<int[]> fires;
	static Deque<int[]> deque;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		fires = new ArrayDeque<>();
		count = 0;

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = data.charAt(j);
				map[i][j] = c;
				if (c == 'F')
					fires.add(new int[] { i, j });
				else if (c == 'J') {
					startX = i;
					startY = j;
				}

			}
		}

		bfs(startX, startY);
	}

	private static void bfs(int startX, int startY) {
		deque = new ArrayDeque<>();
		visited[startX][startY] = true;

		deque.add(new int[] { startX, startY });

		while (!deque.isEmpty()) {
			moveFire();

			int size = deque.size();
			count++;
			for (int i = 0; i < size; i++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];

				if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
					System.out.println(count);
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] { nx, ny });

					}
				}
			}
		}

		System.out.println("IMPOSSIBLE");

	}

	private static void moveFire() {
		int size = fires.size();
		for (int i = 0; i < size; i++) {
			int[] temp = fires.poll();
			int x = temp[0];
			int y = temp[1];
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
						map[nx][ny] = 'F';
						fires.add(new int[] { nx, ny });
					}

				}
			}
		}

	}

}