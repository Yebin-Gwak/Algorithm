import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans;
	static int[][] map;

	static List<int[]> shopIndex = new ArrayList<>();
	static List<int[]> shop = new ArrayList<>();
	static List<int[]> home = new ArrayList<>();
	static int[] input;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		input = new int[M];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new int[] { i, j });
				else if (map[i][j] == 2) {
					shop.add(new int[] { i, j });

				}
			}
		}
		
		visited = new boolean[shop.size()];

		comb(0, 0);

		calc();

		System.out.println(ans);

	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int[] tempArr = new int[M];
			for (int j = 0; j < M; j++) {
				tempArr[j] = input[j];
			}
			shopIndex.add(tempArr);
			return;
		}

		for (int i = start; i < shop.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			input[cnt] = i;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	private static void calc() {
		for (int i = 0; i < shopIndex.size(); i++) {
			int totalSize = 0;
			for (int j = 0; j < home.size(); j++) {
				int homeSize = Integer.MAX_VALUE; 
				for (int k = 0; k < M; k++) {
					int tempSize = Math.abs(home.get(j)[0] - shop.get(shopIndex.get(i)[k])[0])
							+ Math.abs(home.get(j)[1] - shop.get(shopIndex.get(i)[k])[1]);
					if (tempSize < homeSize)
						homeSize = tempSize;
				}
				totalSize += homeSize; 
			}
			if (totalSize < ans)
				ans = totalSize; 
		}
	}
}