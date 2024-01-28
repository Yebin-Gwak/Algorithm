import java.util.*;
import java.io.*;

public class Main {
	static int N, M, count;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] map, field;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		map = new int[M][N];
		field = new int[M][N];
		count = 0;
		int maxRoomSize = 0;
		ArrayList<Integer> roomSizes = new ArrayList<>();
		int maxSizeSum = 0;
		roomSizes.add(0);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count++;
					int size = bfs(i, j, count);
					roomSizes.add(size);
					maxRoomSize = Math.max(maxRoomSize, size);
				}

			}
		}

		ArrayList<ArrayList<Integer>> link = new ArrayList<>();
		link.add(new ArrayList<Integer>());

		for (int a = 1; a <= count; a++) {
			ArrayList<Integer> tempArr = new ArrayList<>();
			boolean[] check = new boolean[count + 1];
			check[a] = true;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (field[i][j] != a)
						continue;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && !check[field[nx][ny]] && a < field[nx][ny]) {
							check[field[nx][ny]] = true;
							tempArr.add(field[nx][ny]);
						}
					}
				}

			}
			link.add(tempArr);
		}

		for (int i = 1; i < link.size(); i++) {
			for (int j = 0; j < link.get(i).size(); j++) {
				maxSizeSum = Math.max(maxSizeSum, roomSizes.get(i) + roomSizes.get(link.get(i).get(j)));
			}
		}

		System.out.println(count);
		System.out.println(maxRoomSize);
		System.out.println(maxSizeSum);

	}

	private static int bfs(int startX, int startY, int count) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		deque.addLast(new int[] { startX, startY });
		int size = 1;

		while (!deque.isEmpty()) {
			int[] temp = deque.pollFirst();
			int x = temp[0];
			int y = temp[1];
			field[x][y] = count;
			String wall = String.format("%04d", Integer.parseInt(Integer.toBinaryString(map[x][y])));

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (wall.charAt(i) == '0' && (0 <= nx && nx < M) && (0 <= ny && ny < N)) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] { nx, ny });
						size++;
					}
				}

			}
		}
		return size;

	}

}