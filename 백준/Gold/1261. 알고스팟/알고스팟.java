import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	static int N, M;
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static List<ArrayList<Node>>[][] nodes;
	static PriorityQueue<Node> pq;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];
		nodes = new ArrayList[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				nodes[i][j] = new ArrayList<>();
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}

		diskstra();

		System.out.println(distance[N - 1][M - 1]);

	}

	private static void diskstra() {
		pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0]));
		distance[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int x = now.x;
			int y = now.y;

			if (!visited[x][y])
				visited[x][y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (valid(nx, ny) && !visited[nx][ny] && distance[nx][ny] > distance[x][y] + map[nx][ny]) {
					distance[nx][ny] = distance[x][y] + map[nx][ny];
					pq.add(new Node(nx, ny, distance[nx][ny]));
				}
			}

		}

	}

	private static boolean valid(int nx, int ny) {
		if (0 <= nx && nx < N && 0 <= ny && ny < M)
			return true;
		return false;
	}
}