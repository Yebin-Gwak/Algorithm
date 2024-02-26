import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R, day;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1 ,1};
	
	static int count;
	static Deque<int[]> deque;
	static Deque<int[]> union;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		play();
		
		System.out.println(day);

	}
	
	private static void play() {
		while(true) {
			count = 0;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			if(count == N * N)
				break;
			day++;
		}
		
		
		
		
		
		

	}

	private static void bfs(int startX, int startY) {
		deque = new ArrayDeque<>();
		union = new ArrayDeque<>();
		
		deque.add(new int[] {startX, startY});
		union.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		
		int size = map[startX][startY];
		
		while(!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					int population = Math.abs(map[x][y] - map[nx][ny]);
					if(L <= population && population <= R) {
						size += map[nx][ny];
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});
						union.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		// 연합이 없으면 바로 종료
		if(union.size() == 1) return;
		
		size = size / union.size();
		while(!union.isEmpty()) {
			int[] temp = union.poll();
			map[temp[0]][temp[1]] = size;
		}
		
		
	}

}