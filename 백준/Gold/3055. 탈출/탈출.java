import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int startX, startY, endX, endY;

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static Deque<int[]> waters = new ArrayDeque<>();
	static Deque<int[]> deque;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);
				if(map[i][j] == '*')
					waters.add(new int[] {i, j});
				else if(map[i][j] == 'D') {
					endX = i;
					endY = j;
				}
				else if(map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);

	}


	private static void bfs(int startX, int startY) {
		deque = new ArrayDeque<>();
		deque.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		
		int time = -1;
		while(!deque.isEmpty()) {
			moveWater();
			time++;
			int size = deque.size();
			
			for(int i = 0; i < size; i++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				
				if(x == endX && y == endY) {
					System.out.println(time);
					return;
				}
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(0 <= nx && nx < N && 0 <= ny && ny < M && (map[nx][ny] == '.' || map[nx][ny] == 'D') && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});
					}
				}
			}
			
		}
		System.out.println("KAKTUS");
		return;
		
	}


	private static void moveWater() {
		int size = waters.size();
		for(int i = 0; i < size; i++) {
			int[] temp = waters.poll();
			int x = temp[0];
			int y = temp[1];
			for(int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
						map[nx][ny] = '*';
						waters.add(new int[] {nx, ny});
					}
					
				}
			}
		}
	}

}