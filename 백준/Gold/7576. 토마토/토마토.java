import java.util.*;
import java.io.*;

public class Main {

	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static int day, leftover;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];
		day = -1;
		leftover = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i][j] = value;
				if (value == 0)
					leftover++;
			}
		}

		bfs();
		if (leftover == 0)
			System.out.println(day);
		else
			System.out.println(-1);

	}

	private static void bfs() {
		Deque<int[]> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					deque.addLast(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		while (!deque.isEmpty()) {
			day++;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				int[] address = deque.pollFirst();
				int x = address[0];
				int y = address[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && !visited[nx][ny]) {
						if (arr[nx][ny] == 0) {
							deque.addLast(new int[] { nx, ny });
							visited[nx][ny] = true;
							leftover--;

						}
					}
				}
			}
		}

	}

}