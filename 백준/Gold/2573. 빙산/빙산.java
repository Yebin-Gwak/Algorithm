import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] count;
	static int time = 0;
	static Deque<int[]> deque = new ArrayDeque<>();
	static Deque<int[]> melting = new ArrayDeque<int[]>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		count = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			time++;
			melt();
			check();
		}
		
		
	}
	private static void check() {
		visited = new boolean[N][M];
		int total = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					if(++total == 2) {
						System.out.println(time);
						System.exit(0);
					}
					count(i, j);
				}
			}
		}
		if(total == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
	}
	
	private static void count(int startX, int startY) {
		deque.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		while(!deque.isEmpty()) {
			int[] now = deque.poll();
			int x = now[0];
			int y = now[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] {nx, ny});
				}
			}
		}
		
	}
	private static void melt() {
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		while(!melting.isEmpty()) {
			int[] now = melting.poll();
			int x = now[0];
			int y = now[1];
			map[x][y] = (map[x][y] - now[2] < 0) ? 0 : map[x][y] - now[2];
		}
		
	}
	
	private static void bfs(int startX, int startY) {
		deque.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		while(!deque.isEmpty()) {
			int[] now = deque.poll();
			int x = now[0];
			int y = now[1];
			int count = 0;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(map[nx][ny] == 0)
						count++;
					else if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});						
					}
				
				}
			}
			melting.add(new int[] {x, y, count});
			
			
			
		}
		
	}

}