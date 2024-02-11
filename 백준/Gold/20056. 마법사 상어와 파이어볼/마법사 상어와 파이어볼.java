import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Deque<int[]>>[] map;
	static int N, M, K;

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<Deque<int[]>>();
			for (int j = 0; j < N; j++)
				map[i].add(new ArrayDeque<int[]>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[x].get(y).add(new int[] { x, y, m, s, d });
		}

		for (int i = 0; i < K; i++) {
			move();
			fusion();
		}
		calc();

		System.out.println(ans);

	}

	private static void move() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) { // 현재 map에 있는 파이어볼 전부 추출
			for (int j = 0; j < N; j++) {
				while (!map[i].get(j).isEmpty()) {
					queue.add(map[i].get(j).poll());
				}
			}
		}

		while (!queue.isEmpty()) { // 추출한 파이어볼을 이동시켜 map에 재할당
			int[] data = queue.poll();
			int x = data[0];
			int y = data[1];
			int m = data[2];
			int s = data[3];
			int d = data[4];

			x += s * dx[d];
			y += s * dy[d];
			if (x < 0) while (x < 0) x += N;
			if (y < 0) while (y < 0) y += N;
			if (N <= x) while (N <= x) x -= N;
			if (N <= y )while (N <= y) y -= N;

			map[x].get(y).add(new int[] { x, y, m, s, d });
		}

	}

	private static void fusion() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i].get(j).size() > 1) { // 한 구역에 2개 이상의 파이어볼이 있다면
					int size = map[i].get(j).size();
					int weight = 0;
					int speed = 0;
					boolean odd = false;
					boolean even = false;
					while (!map[i].get(j).isEmpty()) {
						int[] data = map[i].get(j).poll();
						weight += data[2];
						speed += data[3];
						if (data[4] % 2 == 0) even = true;
						else odd = true;
					}
					
					if (weight / 5 == 0) continue; // 합친 파이어볼의 질량/5가 0이라면 소멸
					
					if (odd != even) { // 한 방향만 true라면(모든 파이어볼이 같은 방향)
						for (int d = 0; d < 8; d += 2)
							map[i].get(j).add(new int[] { i, j, weight / 5, speed / size, d });
					} else { // 둘다 true, 방향에 홀짝이 섞여있음
						for (int d = 1; d < 8; d += 2)
							map[i].get(j).add(new int[] { i, j, weight / 5, speed / size, d });
					}
				}
			}
		}
	}

	private static void calc() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				while (!map[i].get(j).isEmpty()) {
					int[] temp = map[i].get(j).poll();
					ans += temp[2];
				}
			}
		}
	}

}
