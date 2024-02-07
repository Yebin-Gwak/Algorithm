import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, R, cmd;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
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
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < R; i++) {
			int turn = Integer.parseInt(st.nextToken());
			
			switch(turn) {
			case 1:
				upDown();
				break;
				
			case 2:
				leftRight();
				break;
				
			case 3:
				rightTurn();
				break;
				
			case 4:
				leftTurn();
				break;
			
			case 5:
				cutright();
				break;
				
			case 6:
				cutleft();
				break;
			}
		}
		
		printMap();
	}
	
	private static void upDown() {
		int[][] tempList = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempList[i][j] = map[N -1 -i][j];
			}
		}
		map = tempList;
	}
	
	private static void leftRight() {
		int[][] tempList = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tempList[i][j] = map[i][M - 1 - j];
			}
		}
		map = tempList;
	}
	
	private static void rightTurn() {
		int[][] tempList = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				tempList[i][j] = map[N-1-j][i];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		map = tempList;
	}
	
	private static void leftTurn(){
		int[][] tempList = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				tempList[i][j] = map[j][M -1 -i];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		map = tempList;
	}
	
	private static void cutright() {
		int[][] tempList = new int[N][M];
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++){
				tempList[i][M/2 + j] = map[i][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = M/2; j < M; j++){
				tempList[N / 2 + i][j] = map[i][j];
			}
		}

		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++){
				tempList[i][j] = map[i][M / 2 + j];
			}
		}

		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++){
				tempList[i][j] = map[N / 2 + i][j];
			}
		}
		
		map = tempList;
	}
	
	private static void cutleft() {
		int[][] tempList = new int[N][M];
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M / 2; j++){
				tempList[N / 2 + i][j] = map[i][j];
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++){
				tempList[i][M / 2 + j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N / 2; i++) {
			for(int j = M/2; j < M; j++){
				tempList[i][j] = map[N / 2 + i][j];
			}
		}
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++){
				tempList[i][j] = map[i][M/2 + j];
			}
		}
		
		map = tempList;
	}
	
	
	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(map).forEach(row -> {
			Arrays.stream(row).forEach(v -> sb.append(v).append(" "));
			sb.append("\n");
		});
		System.out.println(sb.toString());
	}

}