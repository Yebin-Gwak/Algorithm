import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static Deque<int[]> deque;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count = 0;
	static int max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	private static void bfs(int sX, int sY) {
		deque = new ArrayDeque<>();
		deque.add(new int[] {sX, sY});
		map[sX][sY] = 0;
		
		int size = 0;

		while(!deque.isEmpty()) {
			int[] temp = deque.poll();
			size++;
			int x = temp[0];
			int y = temp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					deque.add(new int[] {nx, ny});
				}
			}
		}
		max = Math.max(max, size);
		
	}

}