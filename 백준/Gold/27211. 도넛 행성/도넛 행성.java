import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				if(map[i][j] == 0 && !visited[i][j]) {
					ans++;
					bfs(i, j);
				}
		}
		
		System.out.println(ans);	
		
	}

	private static void bfs(int startX, int startY) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		deque.add(new int[] {startX, startY});
		
		while(!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];
			for(int i = 0; i < 4; i++) {
				int nx = checkX(x + dx[i]);
				int ny = checkY(y + dy[i]);
				if(map[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] {nx, ny});
				}
			}
		}
		
	}

	private static int checkX(int x) {
		if(x == -1)
			return N - 1;
		if(x == N)
			return 0;
		
		return x;
	}

	private static int checkY(int y) {
		if(y == -1)
			return M - 1;
		if(y == M)
			return 0;
		
		return y;
	}

}
