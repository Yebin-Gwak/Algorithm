import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] originMap;
	static boolean[][] summed;
	// 하 상 우 좌
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int[] startX;
	static int[] endX;
	static int[] indexX;
	static int[] startY;
	static int[] endY;
	static int[] indexY;
	
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

	private static void dfs(int cnt, int[][] originMap) {
		if(cnt == 5) {
			calc(originMap);
			return;
		} 
		
		for(int i = 0; i < 4; i++) {
			int[][] resultMap = move(originMap, i);
			dfs(cnt + 1, resultMap);
		}
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
						// 다음 칸이 0일때
						if(map[x][y] == 0) {
							// 다다음칸이 존재한다면 계속 내림
							if(0 <= x + dx[d] && x + dx[d] < N && 0 <= y + dy[d] && y + dy[d] < N) {
								continue;
							}
							else {
								map[x][y] = value;
								map[sX][sY] = 0;
								break;
							}
						}
						// 다음 칸이 0이 아닐 때
						else {
							// 다음칸 값이 나와 같고, 해당 칸이 아직 안 합쳐졌었다면
							if(value == map[x][y] && !summed[x][y]) {
								summed[x][y] = true;
								map[sX][sY] = 0;
								map[x][y] = value * 2;
								break;
							}
							else {
								map[sX][sY] = 0;
								map[x - dx[d]][y - dy[d]] = value;
								break;
							}
						}
					}
					else break;
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
		
		if(ans == 128) {
			System.out.println(1);
		}
	}
}