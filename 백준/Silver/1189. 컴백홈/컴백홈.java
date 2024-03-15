import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static char map[][];
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = data.charAt(j);
		}
		
		visited[N - 1][0] = true;
		dfs(N - 1, 0, 1);
		
		System.out.println(ans);
		
	}
	
	private static void dfs(int x, int y, int count) {
		if(count > K)
			return;
		
		if(x == 0 && y == M - 1) {
			if(count == K)
				ans++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == '.' && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, count + 1);
				visited[nx][ny] = false;
			}
		}
	}
}