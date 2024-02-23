import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, day;
	static Deque<Integer> deque = new ArrayDeque<>();
	static int[][] map;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(map[i], 1);

		for (int i = 0; i < day; i++) {
			growFirst();
//			growSecond();
			
		}

		for (int i = 0; i < N; i++) {
			sb.append(map[i][0] + " ");
			for (int j = 1; j < N; j++) {
				sb.append(map[0][j] + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());

	}

	private static void growFirst() throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] sizes = new int[3];

		sizes[0] = Integer.parseInt(st.nextToken());
		sizes[1] = Integer.parseInt(st.nextToken());
		sizes[2] = Integer.parseInt(st.nextToken());

		for (int i = N - 1; i >= 0; i--)
			if (sizes[0] > 0)
				sizes[0]--;
			else if (sizes[1] > 0) {
				map[i][0]++;
				sizes[1]--;
			} else {
				map[i][0] += 2;
				sizes[2]--;
			}

		for (int i = 1; i < N; i++)
			if (sizes[0] > 0)
				sizes[0]--;
			else if (sizes[1] > 0) {
				map[0][i]++;
				sizes[1]--;
			} else {
				map[0][i] += 2;
				sizes[2]--;
			}

	}

//	private static void growSecond() {
//		int row = 0;
//		int col = 0;
//
//		for (int i = 1; i < N; i++) {
//			row = 1;
//			col = i;
//			for (int j = 0; j < i; j++) {
//				map[row][col] = Math.max(Math.max(map[row][col - 1], map[row - 1][col]), map[row - 1][col - 1]);
//				row++;
//				col--;
//			}
//
//		}
//
//		for (int i = 2; i < N; i++) {
//			row = i;
//			col = N - 1;
//
//			for (int j = N - i; j > 0; j--) {
//				map[row][col] = Math.max(Math.max(map[row][col - 1], map[row - 1][col]), map[row - 1][col - 1]);
//				row++;
//				col--;
//
//			}
//		}
//	}

}