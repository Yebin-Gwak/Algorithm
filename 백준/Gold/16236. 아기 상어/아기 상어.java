import java.util.*;
import java.io.*;

public class Main {
	static class Shark {
		int x, y, size, exp;

		Shark() {
			this.size = 2;
			this.exp = 0;
		}

	}

	static class Fish implements Comparable<Fish> {
		int x, y;

		public Fish(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Fish o) {
			// x가 낮은 순으로 정렬하며, x가 같다면 y가 낮은 순으로 정렬
			if (this.x == o.x)
				return Integer.compare(this.y, o.y);

			return Integer.compare(this.x, o.x);
		}

	}

	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int ans = 0;
	static int time;
	
	static Shark shark = new Shark();
	static PriorityQueue<Fish> fishs;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 9) {
					map[i][j] = 0;
					shark.x = i;
					shark.y = j;
				}
				else
					map[i][j] = value;

			}
		}

		play();

		System.out.println(ans);

	}

	private static void play() {
		while (true) {
			if (!bfs())
				return;
		}

	}

	private static boolean bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		visited = new boolean[N][N];
		visited[shark.x][shark.y] = true;
		deque.add(new int[] { shark.x, shark.y });

		fishs = new PriorityQueue<>();

		time = 0;
		while (!deque.isEmpty()) {
			time++;
			int size = deque.size();
			for(int k = 0; k < size; k++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && map[nx][ny] <= shark.size) {
						visited[nx][ny] = true;
						if (map[nx][ny] != 0 && map[nx][ny] < shark.size) {
							fishs.add(new Fish(nx, ny));
						} else {
							deque.add(new int[] { nx, ny });
						}
					}
				}
				
			}
			if (!fishs.isEmpty())
				break;
		}

		if (fishs.isEmpty())
			return false;

		eat();
		return true;

	}

	private static void eat() {
		ans += time;
		Fish next = fishs.poll();
		
		shark.x = next.x;
		shark.y = next.y;
		
		map[next.x][next.y] = 0;
		
		if(++shark.exp == shark.size) {
			shark.size++;
			shark.exp = 0;
		}
		
	}

}