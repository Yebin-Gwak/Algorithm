import java.util.*;
import java.io.*;

public class Main {
	static class Shark {
		int x, y, speed, distance, size;

		public Shark(int x, int y, int speed, int distance, int size) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.distance = distance;
			this.size = size;
		}

	}

	static int N, M, K;
	static List<Deque<Shark>>[] map;
	static int fisherY = -1;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<Deque<Shark>>();
			for (int j = 0; j < M; j++) {
				map[i].add(new ArrayDeque<Shark>());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[x].get(y).add(new Shark(x, y, s, d, z));
		}

		for (int i = 0; i < M; i++) {
			fishing();
			move();
			eatCheck();
		}
		System.out.println(ans);

	}

	private static void fishing() {
		fisherY++;

		for (int i = 0; i < N; i++) {
			if (!map[i].get(fisherY).isEmpty()) {
				Shark shark = map[i].get(fisherY).poll();
				ans += shark.size;
				return;
			}
		}
	}

	private static void move() {
		Deque<Shark> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i].get(j).isEmpty())
					deque.add(map[i].get(j).poll());
			}
		}

		while (!deque.isEmpty()) {
			Shark shark = deque.poll();
			for (int i = 0; i < shark.speed; i++) {
				turnCheck(shark);
				shark.x += dx[shark.distance];
				shark.y += dy[shark.distance];
			}

			map[shark.x].get(shark.y).add(shark);
		}

	}

	private static void eatCheck() {
		Deque<Shark> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i].get(j).size() > 1) {
					while (!map[i].get(j).isEmpty()) {
						deque.add(map[i].get(j).poll());
					}
					eat(deque, i, j);
					deque.clear();
				}
			}
		}

	}

	private static void eat(Deque<Shark> deque, int x, int y) {
		Shark now = deque.poll();
		while (!deque.isEmpty()) {
			Shark next = deque.poll();
			if (now.size < next.size)
				now = next;
		}
		map[x].get(y).add(now);

	}

	private static void turnCheck(Shark shark) {
		int d = shark.distance;
		if (d == 0 && shark.x == 0)
			shark.distance = 1;
		else if (d == 1 && shark.x == N - 1)
			shark.distance = 0;
		else if (d == 2 && shark.y == M - 1)
			shark.distance = 3;
		else if (d == 3 && shark.y == 0)
			shark.distance = 2;
	}
}
