import java.util.*;
import java.io.*;

public class Main {
	static int N, M, shopCount;
	static int[][] map;

	static List<int[]> shopIndex = new ArrayList<>();
	static List<int[]> shopAddress = new ArrayList<>();
	static List<int[]> homeAddress = new ArrayList<>();
	static int[] input;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		input = new int[M];
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					homeAddress.add(new int[] { i, j });
				else if (map[i][j] == 2) {
					shopAddress.add(new int[] { i, j });
					shopCount++;
				}
			}
		}

		visited = new boolean[shopCount];

		comb(0, 0);

		for (int i = 0; i < shopIndex.size(); i++) {
			int tempAllDistance = 0;
			for (int j = 0; j < homeAddress.size(); j++) {
				int tempDistance = Integer.MAX_VALUE;
				for (int k = 0; k < M; k++) { // 현재 집에서 가장 가까운 치킨집과의 거리 저장
					int tempSize = Math.abs(homeAddress.get(j)[0] - shopAddress.get(shopIndex.get(i)[k])[0])
							+ Math.abs(homeAddress.get(j)[1] - shopAddress.get(shopIndex.get(i)[k])[1]);
					if (tempSize < tempDistance)
						tempDistance = tempSize;
				}
				tempAllDistance += tempDistance;
			}
			if (tempAllDistance < ans)
				ans = tempAllDistance; 
		}

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

		for (int i = start; i < shopCount; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			input[cnt] = i;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}

	}

}