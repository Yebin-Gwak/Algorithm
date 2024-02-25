import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, D;
	static int[][] map;
	static int[][] tempMap;
	
	static int ans = 0;
	static int score;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M - 2; i++) {
			for(int j = i + 1; j < M - 1; j++) {
				for(int k = j + 1; k < M; k++) {
					bfs(i, j, k);
				}
			}
		}
		
		System.out.println(ans);

	}

	private static void bfs(int arc1, int arc2, int arc3) {
		tempMap = new int[N + 1][];
		for(int i = 0; i < N + 1; i++)
			tempMap[i] = map[i].clone();
		
		score = 0;
		
		while(true) {
			int[] target1 = findTarget(arc1);
			int[] target2 = findTarget(arc2);
			int[] target3 = findTarget(arc3);
			
			if(target1 != null) shoot(target1);
			if(target2 != null) shoot(target2);
			if(target3 != null) shoot(target3);
			
			enemyMove();
			if(!endCheck()) break;
			
		}
		
		ans = Math.max(ans, score);
		
	}

	private static boolean endCheck() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				if(tempMap[i][j] == 1) return true;
		}
		return false;
	}

	private static void enemyMove() {
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				if(tempMap[i][j] == 1) {
					tempMap[i][j] = 0;
					if(i + 1 != N) tempMap[i + 1][j] = 1;
					
				}
			}
		}
		
	}

	private static void shoot(int[] target) {
		int x = target[0];
		int y = target[1];
		
		if(tempMap[x][y] == 1) {
			tempMap[x][y] = 0;
			score++;
		}
		
	}

	private static int[] findTarget(int arcM) {
		int targetX = -1;
		int targetY = -1;
		int minD = Integer.MAX_VALUE;
		
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(tempMap[i][j] == 1) {
					int distance = Math.abs(i - N) + Math.abs(j - arcM);
					if(distance <= D) {
						if(distance < minD) {
							minD = distance;
							targetX = i;
							targetY = j;
						}
						else if(distance == minD && j < targetY) {
							targetX = i;
							targetY = j;
						}
						
					}
				}
			}
		}
		
		if(minD != Integer.MAX_VALUE)
			return new int[] {targetX, targetY};
		
		return null;
	}

}