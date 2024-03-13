import java.util.*;
import java.io.*;

public class Main {
	static int[][] map = new int[9][9];
	static boolean find = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void dfs(int x, int y) {
		if (find)
			return;
		if (x == 9) {
			find = true;
			return;
		}
		if (map[x][y] != 0) {
			if (y == 8)
				dfs(x + 1, 0);
			else
				dfs(x, y + 1);
		} else {
			boolean[] numCheck = new boolean[10];

			for (int i = 1; i < 10; i++) {
				if (colCheck(x, i) && rowCheck(y, i) && squareCheck(x, y, i)) {
					map[x][y] = i;
					if (y == 8) {
						dfs(x + 1, 0);
					} else
						dfs(x, y + 1);
					if (find)
						return;
					map[x][y] = 0;
				}
			}
		}

	}

	private static boolean colCheck(int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num) return false; 
		}
		return true;
	}

	private static boolean rowCheck(int y, int num) {
		for (int i = 0; i < 9; i++) {
				if(map[i][y] == num) return false;
		}
		return true;
	}

	private static boolean squareCheck(int x, int y, int num) {
		x = 3 * (x / 3);
		y = 3 * (y / 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[x + i][y + j] == num) return false;
			}
		}
		return true;
	}

}