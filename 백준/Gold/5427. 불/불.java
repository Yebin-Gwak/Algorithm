import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int W, H, startX, startY, count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Deque<int[]> fires;
	static Deque<int[]> deque;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			visited = new boolean[H][W];
			fires = new ArrayDeque<>();
			count = 0;
			
			for(int i = 0; i < H; i++) {
				String data = br.readLine();
				for(int j = 0; j < W; j++) {
					char c = data.charAt(j);
					map[i][j] = c;
					if(c == '*')
						fires.add(new int[] {i, j});
					else if(c == '@') {
						startX = i;
						startY = j;
					}
					
				}
			}

			bfs(startX, startY);
			
		}
		
		System.out.println(sb.toString());
	}
	
	private static void bfs(int startX, int startY) {
		deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		
		deque.add(new int[] {startX, startY});
		
		while(!deque.isEmpty()) {
			moveFire();

			int size = deque.size();
			count++;
			for(int i = 0; i < size; i++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				
				if(x == 0 || x == H - 1 || y == 0 || y == W - 1) {
					sb.append(count + "\n");
					return;
				}
				
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = '@';
						deque.add(new int[] {nx, ny});
						
					}
				}
			}
		}
		
		sb.append("IMPOSSIBLE\n");
		
	}
	
	private static void moveFire() {
		int size = fires.size();
		for(int i = 0; i < size; i++) {
			int[] temp = fires.poll();
			int x = temp[0];
			int y = temp[1];
			for(int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(0 <= nx && nx < H && 0 <= ny && ny < W) {
					if(map[nx][ny] == '.' || map[nx][ny] == '@') {
						map[nx][ny] = '*';
						fires.add(new int[] {nx, ny});
					}
					
				}
			}
		}

	}
	
}