import java.util.*;
import java.io.*;

public class Main {
	static int N, M, x, y, turn, ans;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int[][] map;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		turn = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		while (true) {
			check = false;
			if (map[x][y] == 0) {
				map[x][y] = 2;
				ans++;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
					check = true;
					break;
				}
			}
			if (check)
				turnAndMove();
			else if (!goBack())
				return;

		}

	}

	private static void turnAndMove() {
		turn = (turn == 0) ? 3 : turn - 1; // 역방향 90도 회전, turn이 0이면 3으로, 아니면 turn -1로 조정
		int nx = x + dx[turn];
		int ny = y + dy[turn];
		if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
			x = nx;
			y = ny;
		}

	}

	private static boolean goBack() {
		turn = (turn < 2) ? (4 - Math.abs(turn - 2)) : turn - 2;
		int nx = x + dx[turn];
		int ny = y + dy[turn];
		if (0 <= nx && nx <= N && 0 <= ny && ny <= M && map[nx][ny] != 1) {
			x = nx;
			y = ny;
			turn = (turn < 2) ? (4 - Math.abs(turn - 2)) : turn - 2;
			return true;
		} else
			return false;
	}

}