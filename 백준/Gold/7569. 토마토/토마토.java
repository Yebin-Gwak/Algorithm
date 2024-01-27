import java.util.*;
import java.io.*;

public class Main {

	static int M, N, H;
	static int[][][] arr;
	static boolean[][][] visited;
	static int[] dx = new int[] { 0, 0, 1, -1, 0, 0 };
	static int[] dy = new int[] { 1, -1, 0, 0, 0, 0 };
	static int[] dh = new int[] { 0, 0, 0, 0, 1, -1 };
	static int day, leftover;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		visited = new boolean[H][N][M];
		day = -1;
		leftover = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int value = Integer.parseInt(st.nextToken());
					if (value == 0)
						leftover++;
					arr[i][j][k] = value;
				}
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

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 1) {
						deque.addLast(new int[] { i, j, k });
						visited[i][j][k] = true;
					}
				}
			}
		}

		while (!deque.isEmpty()) {
			day++;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				int[] address = deque.pollFirst();
				int h = address[0];
				int x = address[1];
				int y = address[2];

				for (int j = 0; j < 6; j++) {
					int nh = h + dh[j];
					int nx = x + dx[j];
					int ny = y + dy[j];

					if ((nh >= 0 && nh < H) && (nx >= 0 && nx < N) && (ny >= 0 && ny < M) && !visited[nh][nx][ny]) {
						if (arr[nh][nx][ny] == 0) {
							deque.addLast(new int[] { nh, nx, ny });
							visited[nh][nx][ny] = true;
							leftover--;

						}
					}
				}
			}
		}

	}

}