import java.util.*;
import java.io.*;

public class Main {
	static char[][] map = new char[8][8];
	static boolean[][] visited = new boolean[8][8];
	
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 8; i++) {
			String data = br.readLine();
			for(int j = 0; j < 8; j++)
				map[i][j] = data.charAt(j);
		}
		
		bfs();
		
		
	}
	private static void bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {7, 0});
		visited[7][0] = true;
		
		while(!deque.isEmpty()) {

			int size = deque.size();
			for(int t = 0; t < size; t++) {
				int[] now = deque.poll();
				int x = now[0];
				int y = now[1];
				if(x == 0 && y == 7) {
					System.out.println(1);
					return;
				}
				if(map[x][y] == '#')
					continue;
				
				visited[x][y] = true;
				deque.add(new int[] {x, y});
				for(int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < 8 && 0 <= ny && ny < 8 && map[nx][ny] == '.' && !visited[nx][ny]) {
						deque.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
			visited = new boolean[8][8];
			drop();
		}
		System.out.println(0);
	}
	
	private static void drop() {
		Arrays.fill(map[7], '.');
		for(int i = 6; i >= 0; i--) {
			for(int j =  0; j < 8; j++) {
				if(map[i][j] == '#') {
					map[i + 1][j] = '#';
					map[i][j] = '.';
				}
			}
		}
	}

}