import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] parents;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] check;
	static int answer = 0;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		make();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) 
					dfs(i, j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[parents[i][j]]) {
					answer++;
					check[parents[i][j]] = true;
				}
			}
		}
		
		System.out.println(answer);
		
	}

	private static int dfs(int x, int y) {
		visited[x][y] = true;
		char c = map[x][y];
		int x2 = x;
		int y2 = y;
		if(c == 'L') y2--;
		if(c == 'R') y2++;
		if(c == 'U') x2--;
		if(c == 'D') x2++;
		
		if(visited[x2][y2]) {
			parents[x][y] = parents[x2][y2];
			return parents[x2][y2];
		}

		parents[x][y] = dfs(x2, y2);
		return parents[x][y];
	}

	private static void make() throws IOException{
		map = new char[N][M];
		parents = new int[N][M];
		visited = new boolean[N][M];
		check = new boolean[N * M];
		int count = 0;
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j);
				parents[i][j] = count++;
			}
		}
	}
	
}