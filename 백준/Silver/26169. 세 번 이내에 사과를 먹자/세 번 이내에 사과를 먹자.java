import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map = new int[5][5];
	static int[] dx = new int[] {1, -1, 0, 0};
	static int[] dy = new int[] {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[nx][ny] != -1) {
				int now = 0;
				int next = map[nx][ny];
				map[x][y] = -1;
				dfs(nx, ny, (next == 1) ? 1 : 0, 1);
				map[x][y] = now;
			}
			
		}
		
		System.out.println(0);
	}

	private static void dfs(int x, int y, int v, int c) {
		if(v == 2) {
			System.out.println(1);
			System.exit(0);
		}
		if(c == 3)
			return;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[nx][ny] != -1) {
				int now = map[x][y];
				int next = map[nx][ny];
				map[x][y] = -1;
				dfs(nx, ny, (next == 1) ? v + 1 : v, c + 1);
				map[x][y] = now;
			}
		}
		
	}
}