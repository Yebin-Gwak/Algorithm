import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static boolean[][] cleaned;
	static int[][] ruleA;
	static int[][] ruleB;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int X, Y, D;
	static int count = 0;
	static int tempCount = 0;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cleaned = new boolean[N][M];
		ruleA = new int[N][M];
		ruleB = new int[N][M];
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++)
				ruleA[i][j] = data.charAt(j) - '0';
		}
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++)
				ruleB[i][j] = data.charAt(j) - '0';
		}

		visited = new boolean[N][M][4];
		while (true) {
			cleaned[X][Y] = true;
			findNext();
		}

	}

	private static void turnA() {
		D = (D + ruleA[X][Y]) % 4;
		X += dx[D];
		Y += dy[D];
		count++;
		if (invalid()) {
			System.out.println(count);
			System.exit(0);
		}

	}

	private static void findNext() {
		visited = new boolean[N][M][4];
		turnA();
		
		if(!cleaned[X][Y])
			return;
		
		int tempCount = 0;
		while(true) {
			D = (D + ruleB[X][Y]) % 4;
			X += dx[D];
			Y += dy[D];
			tempCount++;
			
			if(invalid() || visited[X][Y][D]) {
				System.out.println(count);
				System.exit(0);
			}
			
			if(!cleaned[X][Y]) {
				count += tempCount;
				return;
			}
			visited[X][Y][D] = true;
		}
	}

	private static boolean invalid() {
		if (0 <= X && X < N && 0 <= Y && Y < M)
			return false;
		return true;
	}

}
