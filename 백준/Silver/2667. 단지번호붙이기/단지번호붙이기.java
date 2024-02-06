import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> sizes = new ArrayList<Integer>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();

		map = new int[N][N];
		visited = new boolean[N][N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			String mapData = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = mapData.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}

		Collections.sort(sizes);

		System.out.println(count);

		for (int x : sizes)
			System.out.println(x);

	}

	private static void bfs(int startX, int startY) {
		Deque<int[]> deque = new ArrayDeque<int[]>();
		visited[startX][startY] = true;
		deque.add(new int[] { startX, startY });
		int size = 0;

		while (!deque.isEmpty()) {
			size++;
			int[] temp = deque.pollFirst();

			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.addLast(new int[] { nx, ny });
				}
			}

		}

		sizes.add(size);

	}

}