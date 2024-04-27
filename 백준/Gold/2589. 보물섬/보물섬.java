import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = data.charAt(j);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L')
					bfs(i, j);
			}
		}
		System.out.println(ans);
		
	}

	private static void bfs(int startX, int startY) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited = new boolean[N][M];
		visited[startX][startY] = true;
		deque.add(new int[] {startX, startY});
		
		int time = -1;
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 'L' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});
					}
				}
			}
			time++;
		}
		ans = Math.max(ans, time);
		
		
	}

}
