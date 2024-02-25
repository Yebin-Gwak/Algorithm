import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, startX, startY, X, Y, D;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int tc, d;
	static List<int[]>[] holes; 
	static int score, maxScore = 0;
	
	static int[][] walls = {
			{},
			{2, 3, 1, 0},
			{1, 3, 0, 2},
			{3, 2, 0, 1},
			{2, 0, 3, 1},
			{2, 3, 0, 1}
	};
			// 벽/현재/전환
	

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for( tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N + 2][N + 2];
			holes = new ArrayList[5];
			for(int i = 0; i < 5; i++) {
				holes[i] = new ArrayList<int[]>();
			}
			
			maxScore = 0;
			for(int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < N + 1; j++) {
					int value = Integer.parseInt(st.nextToken());
					map[i][j] = value;
					
					if(6 <= value && value <= 10)
						holes[value - 6].add(new int[] {i, j});
				}
			}
			
			// 맵 가장자리 5로 채워주기
			Arrays.fill(map[0], 5);
			Arrays.fill(map[N + 1], 5);
			for(int i = 0; i < N + 2; i++) {
				map[i][0] = 5;
				map[i][N + 1] = 5;
			}
			
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(map[i][j] == 0) {
						start(i, j, 0);
						start(i, j, 1);
						start(i, j, 2);
						start(i, j, 3);
					}
				}
			}
			
			
			sb.append("#" + tc + " " + maxScore + "\n");
			
		}
		System.out.print(sb.toString());
		
	}

	private static void start(int sX, int sY, int d) {
		startX = sX;
		startY = sY;
		X = startX;
		Y = startY;
		D = d;

		score = 0;

		while(true) {
			X += dx[D];
			Y += dy[D];
			
			if(1 <= map[X][Y] && map[X][Y] <= 5) block();
			else if(6 <= map[X][Y] && map[X][Y] <= 10) teleport();

			if(!endCheck()) break;
			
		}

		maxScore = Math.max(maxScore, score);
		
	}
	
	private static boolean endCheck() {
		if(X == startX && Y == startY) return false;
		if(map[X][Y] == -1) return false;
		return true;
	}
	
	
	private static void block() {
		int wall = map[X][Y];
		score++;

		D = walls[wall][D];
	}

	private static void teleport() {
		int no = map[X][Y] - 6;
		int[] start = holes[no].get(0);
		int[] end = holes[no].get(1);
		if(start[0] == X && start[1] == Y) {
			X = end[0];
			Y = end[1];
		}
		else {
			X = start[0];
			Y = start[1];
		}
		
	}
	
}