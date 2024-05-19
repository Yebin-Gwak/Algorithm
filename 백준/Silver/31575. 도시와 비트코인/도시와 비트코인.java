import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
		
		
	}
	private static void bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		visited = new boolean[N][M];
		visited[0][0] = true;
		deque.add(new int[] {0, 0});
		
		while(!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];
			if(x == N - 1 && y == M - 1) {
				System.out.println("Yes");
				return;
			}
			for(int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] {nx, ny});
				}
			}
			
		}
		System.out.println("No");
		
	}

}