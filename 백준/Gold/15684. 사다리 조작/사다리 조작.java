import java.util.*;
import java.io.*;

public class Main {

	static int N, M, K;
	
	static int[][] map;
	
	static int ans = 4;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N + 2][M + 1];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int startLine = Integer.parseInt(st.nextToken());
			int nextLine = startLine + 1;
			
			map[height][startLine] = nextLine;
			map[height][nextLine] = startLine;
			
			
		}
		
		dfs(1, 1, 0);
		
		if(ans == 4)
			System.out.println(-1);
		else
			System.out.println(ans);
	}


	private static void dfs(int x, int y, int cnt) {
		if(cnt >= ans || ans == 0)
			return;
		
		if(cnt == 3) {
			calc(cnt);
			return;
		}
		
		if(x == N + 1 && y == 1) {
			calc(cnt);
			return;
		}
		
		//먼저, 이 줄에 더이상 연결하지 않는 경우
		dfs(x + 1, 1, cnt);			
		
		for(int i = y; i < M; i++) {
			if(map[x][i] != 0)
				continue;
			
			if(map[x][i + 1] == 0) {
				map[x][i] = i + 1;
				map[x][i + 1] = i;
					
				if(y + 2 >= M) {
					dfs(x + 1, 1, cnt + 1);			
				}
				else
					dfs(x, y + 2, cnt + 1);
					
				map[x][i] = 0;
				map[x][i + 1] = 0;
					
			}
		}
		
	}


	private static void calc(int cnt) {
		for(int i = 1; i <= M; i++) {
			int x = 0;
			int y = i;
			
			while(x != N + 1) {
				x++;
				if(map[x][y] == 0)
					continue;
				else 
					y = map[x][y];
			}
			
			if(y != i)
				return;
			
		}
		ans = cnt;
		
	}

}