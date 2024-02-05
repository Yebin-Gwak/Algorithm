import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int ans = 0;
	static int nx1, ny1, nx2, ny2, nx3, ny3, nx4, ny4;
	static int[][][] routeLine = {
			{{0,0},{0,1},{0,2},{0,3}},
			{{0,0},{1,0},{2,0},{3,0}}
			};
	
	static int[][][] routeSquare = {
			{{0,0},{0,1},{1,0},{1,1}}
			};
	
	static int[][][] routeL = {
			{{-2,0},{-1,0},{0,0},{0,1}},
			{{0,0},{1,0}, {0,1},{0,2}},
			{{0,-1},{0,0},{1,0},{2,0}},
			{{0,-2},{0,-1},{0,0},{-1,0}},
			{{0,-1},{0,0},{-1,0},{-2,0}},
			{{0,0},{0,1},{1,0},{2,0}},
			{{0,-2},{0,-1},{0,0},{1,0}},
			{{-1,0},{0,0},{0,1},{0,2}}
			};
	
	static int[][][] routeThunder = {
			{{-1,0},{0,0},{0,1},{1,1}},
			{{1,-1},{1,0},{0,0},{0,1}},
			{{1,-1},{0,-1},{0,0},{-1,0}},
			{{0,-1},{0,0},{1,0},{1,1}}
	};
	
	static int[][][] routeH = {
			{{0,-1},{0,0},{-1,0},{0,1}},
			{{-1,0},{0,0},{1,0},{0,1}},
			{{0,-1},{0,0},{1,0},{0,1}},
			{{0,-1},{-1,0},{0,0},{1,0}}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				calc(i, j, routeLine);
				calc(i, j, routeSquare);
				calc(i, j, routeL);
				calc(i, j, routeThunder);
				calc(i, j, routeH);
			}
		}
		System.out.println(ans);
	}
	
	private static void calc(int x, int y, int[][][] route) {
		for(int i = 0; i < route.length; i++) {
			int tempSum = 0;
			nx1 = x + route[i][0][0];
			ny1 = y + route[i][0][1];
			if(!(0 <= nx1 && nx1 < N && 0 <= ny1 && ny1 < M)) continue;
			
			nx2 = x + route[i][1][0];
			ny2 = y + route[i][1][1];
			if(!(0 <= nx2 && nx2 < N && 0 <= ny2 && ny2 < M)) continue;
			
			nx3 = x + route[i][2][0];
			ny3 = y + route[i][2][1];
			if(!(0 <= nx3 && nx3 < N && 0 <= ny3 && ny3 < M)) continue;
			
			nx4 = x + route[i][3][0];
			ny4 = y + route[i][3][1];
			if(!(0 <= nx4 && nx4 < N && 0 <= ny4 && ny4 < M)) continue;
			
			tempSum += map[nx1][ny1] + map[nx2][ny2] + map[nx3][ny3] + map[nx4][ny4];
			ans = Math.max(ans, tempSum);
		}
	}
}