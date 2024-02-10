import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			calc(x1, y1, x2, y2);
		}
		System.out.println(sb.toString());

	}

	private static void calc(int x1, int y1, int x2, int y2) {
		int sum = 0;

		for (int i = x1; i <= x2; i++) {
			sum += arr[i][y2] - arr[i][y1 - 1];
		}
		sb.append(sum + "\n");
	}
}
