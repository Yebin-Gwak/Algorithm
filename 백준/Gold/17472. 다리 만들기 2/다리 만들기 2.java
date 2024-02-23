import java.util.*;
import java.io.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int islandNum = 0;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int[] parents;
	static List<Edge> edgeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 먼저 각 섬의 번호를 매기고
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					islandNum++;
					bfs(i, j);
				}
			}
		}

		// 섬의 개수만큼 parents 배열 크기 설정
		parents = new int[islandNum + 1];

		// parents 부모 간선 초기화
		make();

		// 이후 섬들끼리 연결하는 간선 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					connect(i, j, map[i][j]);
				}
			}
		}

		// 간선들을 거리 오름차순으로 정렬
		Collections.sort(edgeList);

		int cnt = 0;
		int weight = 0;

		//최단거리부터 하나씩 연결
		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) continue;
			cnt++;
			weight += edge.weight;
			if (cnt == islandNum - 1)
				break;
		}

		if (cnt == islandNum - 1)
			System.out.println(weight);
		else // 모든 섬들이 연결된 것이 아닌 경우
			System.out.println(-1);

	}

	private static void bfs(int startX, int startY) {
		Deque<int[]> deque = new ArrayDeque<int[]>();
		visited[startX][startY] = true;
		deque.add(new int[] { startX, startY });

		while (!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];
			map[x][y] = islandNum;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] { nx, ny });
				}
			}

		}

	}

	private static void connect(int startX, int startY, int num) {
		for (int i = 0; i < 4; i++) { // 현재 위치 기준으로 쭉 사방탐색
			int x = startX;
			int y = startY;
			int weight = 0;

			while (true) {
				x += dx[i];
				y += dy[i];
				if (0 <= x && x < N && 0 <= y && y < M) {
					if (map[x][y] == num) { // 해당 방향이 자신의 섬 이라면 종료
						break;
					} else if (map[x][y] == 0) // 해당 방향이 0이라면 거리 증가
						weight++;
					else { // 해당 방향이 자신의 섬도, 0도 아니라면 다른 섬에 도착한 것
						// 다리 길이가 2 이상인 경우만 간선 추가
						if (weight > 1)
							edgeList.add(new Edge(num, map[x][y], weight));
						break;
					}
					continue;
				}
				break;
			}

		}

	}

	private static void make() {
		for (int i = 1; i <= islandNum; i++)
			parents[i] = i;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

}