import java.util.*;
import java.io.*;

public class Main {
	static int[][][] originMap = new int[5][5][5];
	static int[][][][] map = new int[4][5][5][5];
	
	//조합구하기용
	static boolean[] visited = new boolean[5];
	static int[] input = new int[5];
	static int[][] startPoint = {{0, 0}, {0, 4}, {4, 0}, {4, 4}};
	static int[][] endPoint = {{4, 4}, {4, 0}, {0, 4}, {0, 0}};
	
	static int[] dz = {1, -1};
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 5; k++) {
					originMap[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		initMapData();
		orderComb(0);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
	
	private static void initMapData() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[0][i][j] = originMap[i][j].clone();
			}
		}
		
		for(int i = 1; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = turnMap(map[i - 1][j]);
			}
		}
		
	}

	private static int[][] turnMap(int[][] map){
		int[][] newMap = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				newMap[i][j] = map[4 - j][i];
			}
		}
		return newMap;
	}
	
	private static void orderComb(int cnt) {
		if(cnt == 5) {
			rotationComb(input.clone());
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			input[cnt] = i;
			orderComb(cnt + 1);
			visited[i] = false;
		}
		
	}

	private static void rotationComb(int[] order) {
		Deque<int[]> stack = new ArrayDeque<>();
		
		int[][][] tempMap = new int[5][5][5];
		for(int a = 0; a < 4; a++) {
			tempMap[0] = copyMap(a, order[0]);
			for(int b = 0; b < 4; b++) {
				tempMap[4] = copyMap(b, order[4]);
				boolean possible = false;
				for(int i = 0; i < 4; i++) {
					int startX = startPoint[i][0];
					int startY = startPoint[i][1];
					
					int endX = endPoint[i][0];
					int endY = endPoint[i][1];
					if(tempMap[0][startX][startY] == 1 && tempMap[4][endX][endY] == 1) {
						possible = true;
						break;
					}
				}
				if(possible) {
					for(int c = 0; c < 4; c++) {
						tempMap[1] = copyMap(c, order[1]);
						for(int d = 0; d < 4; d++) {
							tempMap[2] = copyMap(d, order[2]);
							for(int e = 0; e < 4; e++) {
								tempMap[3] = copyMap(e, order[3]);
								for(int i = 0; i < 4; i++) {
									int startX = startPoint[i][0];
									int startY = startPoint[i][1];
									
									int endX = endPoint[i][0];
									int endY = endPoint[i][1];
									if(tempMap[0][startX][startY] == 1 && tempMap[4][endX][endY] == 1) {
										stack.add(new int[] {startX, startY, endX, endY});
									}
								}
								
								while(!stack.isEmpty()) {
									int[] coor = stack.poll();
									bfs(tempMap, coor[0], coor[1], coor[2], coor[3]);
								}
							}
						}
					}
					
				}
					
					

			}
		}
		
		
	}
	
	private static int[][] copyMap(int turn, int floor){
		int[][] tempMap = new int[5][5];
		for(int i = 0; i < 5; i++) {
			tempMap[i] = map[turn][floor][i].clone();
		}
		
		return tempMap;
		
	}
	
	private static void bfs(int[][][] map, int startX, int startY, int endX, int endY) {
		boolean[][][] visited = new boolean[5][5][5];
		Deque<int[]> deque = new ArrayDeque<>();
		visited[0][startX][startY] = true;
		deque.add(new int[] { 0, startX, startY });
		int time = 0;
		while (!deque.isEmpty()) {
			if(ans == 12) {
				System.out.println(12);
				System.exit(0);
			}
			if(time >= ans)
				return;
			
			int size = deque.size();
			for (int t = 0; t < size; t++) {
				int[] temp = deque.poll();
				int z = temp[0];
				int x = temp[1];
				int y = temp[2];

				if (z == 4 && x == endX && y == endY) {
					ans = Math.min(ans, time);
					return;
				}
				
				for(int i = 0; i < 2; i++) {
					int nz = z + dz[i];
					if (0 <= (nz) && (nz) < 5 && map[nz][x][y] == 1 && !visited[nz][x][y]) {
						visited[nz][x][y] = true;
						deque.add(new int[] { nz, x, y });
					}
				}

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[z][nx][ny] == 1 && !visited[z][nx][ny]) {
						visited[z][nx][ny] = true;
						deque.add(new int[] { z, nx, ny });
					}
				}

			}
			time++;
		}
		
	}

}
