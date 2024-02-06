import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N, M, R;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++)
			turn();
		
		for(int i = 0; i < N; i++) {
			for(int x : map[i])
				System.out.print(x + " ");
			System.out.println();
		}
	}
	
	private static void turn() {
		for(int j = 0; j < Math.min(N, M)/2; j++) {
			int x = j;
			int y = j;
			int d = 0;
			
			int temp = map[x][y];
			
			while(d < 4) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(j <= nx && nx < N - j && j <= ny && ny < M - j) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				else
					d++;
			}
			map[j + 1][j] = temp;
		}
	}
}