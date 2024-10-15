import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node> {
		int x, y, d, cost;

		public Node(int x, int y, int d, int cost) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int N, M;
	static char[][] map;
	static int[][][] distances;
	static boolean[][][] visited;
	static int startX = -1, startY = -1, endX = -1, endY = -1;

	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	// 상하좌우의 역
	static int[] reverseD = new int[] { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		distances = new int[N][M][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(distances[i][j], Integer.MAX_VALUE);
			}
		}
		visited = new boolean[N][M][4];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = s.charAt(j);
				map[i][j] = s.charAt(j);
				if (c == 'C') {
					if (startX == -1) {
						startX = i;
						startY = j;
					} else {
						endX = i;
						endY = j;
					}
				}
			}
		}

		dijkstra();

	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// pq에 시작점 기준 4방향 넣음
		for (int i = 0; i < 4; i++) {
			pq.add(new Node(startX, startY, i, 0));
			distances[startX][startY][i] = 0;
		}

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int x = now.x;
			int y = now.y;
			int d = now.d;

			if (x == endX && y == endY) {
				System.out.println(now.cost);
				return;
			}
			if (!visited[x][y][d]) {
				visited[x][y][d] = true;
			}

			// 역방향은 안가며, 방향이 바뀌면 cost + 1
			for (int i = 0; i < 4; i++) {
				if (reverseD[i] == d) {
					continue;
				}
				int nx = x + dx[i];
				int ny = y + dy[i];
				int cost = (i == d) ? 0 : 1;
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != '*' && now.cost + cost < distances[nx][ny][i]
						&& !visited[nx][ny][i]) {
					distances[nx][ny][i] = now.cost + cost;
					pq.add(new Node(nx, ny, i, now.cost + cost));
				}
			}
		}
	}
}
