import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] alpha;
	static int x, y;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		alpha = new boolean[26];

		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = data.charAt(j);
			}
		}

		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int cnt) {
		if (cnt == R * C) {
			ans = Math.max(ans, cnt);
			return;
		}
		boolean move = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && !alpha[map[nx][ny] - 'A']) {
				move = true;

				visited[x][y] = true;
				alpha[map[nx][ny] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				visited[x][y] = false;
				alpha[map[nx][ny] - 'A'] = false;

			}
		}
		if (!move && cnt > ans) {
			ans = cnt;
		}

	}

}