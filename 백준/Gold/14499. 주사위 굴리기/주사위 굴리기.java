import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static int N, M, X, Y, K;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] dice = new int[7];

	// 동서북남
	static int[][] turn = { { 4, 2, 1, 6, 5, 3 }, { 3, 2, 6, 1, 5, 4 }, { 5, 1, 3, 4, 6, 2 }, { 2, 6, 3, 4, 1, 5 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			if (move(d - 1))
				calc();
		}

		System.out.print(sb.toString());
	}

	private static boolean move(int d) {
		if (X + dx[d] < 0 || X + dx[d] >= N || Y + dy[d] < 0 || Y + dy[d] >= M)
			return false;

		X += dx[d];
		Y += dy[d];

		int[] temp = new int[7];
		for (int i = 1; i <= 6; i++)
			temp[i] = dice[turn[d][i - 1]];
		dice = temp;

		return true;
	}

	private static void calc() {
		if (map[X][Y] == 0)
			map[X][Y] = dice[6];
		else {
			dice[6] = map[X][Y];
			map[X][Y] = 0;
		}
		sb.append(dice[1] + "\n");
	}
}