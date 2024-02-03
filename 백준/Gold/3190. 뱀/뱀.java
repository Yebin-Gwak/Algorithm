import java.util.*;
import java.io.*;

public class Main {
	static int N, sec, turn;
	static int[][] map;
	static char[] cmd = new char[10001];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Deque<int[]> deque = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		turn = 0;
		sec = 0;
		deque.add(new int[] { 1, 1 });

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			cmd[x] = c;
		}

		bfs();

		System.out.println(sec);

	}

	private static void bfs() {
		map[1][1] = 1;
		while (true) {
			sec++;
			int[] head = deque.peekLast();
			int nx = head[0] + dx[turn];
			int ny = head[1] + dy[turn];

			if (0 < nx && nx <= N && 0 < ny && ny <= N && map[nx][ny] != 1) {
				if (map[nx][ny] == 2)
					eat(nx, ny);
				else
					move(nx, ny);

				if (cmd[sec] != 0)
					turn(cmd[sec]);
			} else
				break;
		}
	}

	private static void move(int nx, int ny) {
		map[nx][ny] = 1;
		deque.addLast(new int[] { nx, ny });

		int[] tail = deque.pollFirst();
		map[tail[0]][tail[1]] = 0;
	}

	private static void eat(int nx, int ny) {
		map[nx][ny] = 1;
		deque.addLast(new int[] { nx, ny });
	}

	private static void turn(char d) {
		if (d == 'D') {
			turn = (turn == 3) ? 0 : turn + 1;
		} else {
			turn = (turn == 0) ? 3 : turn - 1;
		}
	}
}
