import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] originMap;
	static boolean[][] summed;

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int[] startX, endX, indexX;
	static int[] startY, endY, indexY;
	
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		originMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				originMap[i][j] = Integer.parseInt(st.nextToken());
		}
		
		startX = new int[] {N - 1, 0, 0, 0};
		endX = new int[] {-1, N, N, N};
		indexX = new int[] {-1, 1, 1, 1};
		
		startY = new int[] {0, 0, N - 1, 0};
		endY = new int[] {N, N, -1, N};
		indexY = new int[]{1, 1, -1, 1};
		
		dfs(0, originMap);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int[][] map) {
		if(cnt == 5) {
			calc(map);
			return;
		} 
		
		for(int i = 0; i < 4; i++) 
			dfs(cnt + 1, move(map, i));
	}

	private static int[][] move(int[][] tempMap, int d) {
		int[][] map = new int[N][];
		for(int i = 0; i < N; i++)
			map[i] = tempMap[i].clone();
		
		summed = new boolean[N][N];
		int sX = startX[d];
		while(sX != endX[d]) {
			int sY = startY[d];
			while(sY != endY[d]) {
				int x = sX;
				int y = sY;
				int value = map[x][y];
	
				if(value == 0) {
					sY += indexY[d];
					continue;
				}
				while(true) {
					x += dx[d];
					y += dy[d];
					if(0 <= x && x < N && 0 <= y && y < N) {
						if(map[x][y] == 0) {
							if(0 <= x + dx[d] && x + dx[d] < N && 0 <= y + dy[d] && y + dy[d] < N)
								continue;
							map[x][y] = value;
							map[sX][sY] = 0;
							break;
						}
						else {
							if(value == map[x][y] && !summed[x][y]) {
								summed[x][y] = true;
								map[sX][sY] = 0;
								map[x][y] = value * 2;
								break;
							}
							map[sX][sY] = 0;
							map[x - dx[d]][y - dy[d]] = value;
							break;
						}
					}
					break;
				}
				sY += indexY[d];
			}
			sX += indexX[d];
		}
		return map;
	}

	private static void calc(int[][] map) {
		for(int[] arr : map)
			for(int x : arr)
				ans = Math.max(ans, x);
	}
}