import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans = 0;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String mapData = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = mapData.charAt(j) - '0';
			}
		}

		bfs(0, 0);
		System.out.println(ans);

	}

	private static void bfs(int startX, int startY) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		deque.addLast(new int[] { startX, startY });

		while (!deque.isEmpty()) {
			ans++;
			int size = deque.size();

			for (int k = 0; k < size; k++) {
				int[] data = deque.pollFirst();
				int x = data[0];
				int y = data[1];
				if (x == N - 1 && y == M - 1)
					return;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.addLast(new int[] { nx, ny });
					}
				}
			}
		}

	}
}