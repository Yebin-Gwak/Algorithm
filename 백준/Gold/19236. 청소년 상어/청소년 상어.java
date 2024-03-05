import java.util.*;
import java.io.*;

public class Main {
	static int[][][] map = new int[4][4][2];
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				map[i][j][0] = num;
				map[i][j][1] = d;
			}
		}
		
		dfs(0, 0, 0, map);
		
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int sum, int[][][] original) {
		int[][][] tempMap = new int[4][4][2];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				tempMap[i][j] = original[i][j].clone();
				tempMap[i][j] = original[i][j].clone();
			}
				
			
		}
		
		sum += tempMap[x][y][0];
		int d = tempMap[x][y][1];
		
		tempMap[x][y][0] = 0;
		tempMap[x][y][1] = 0;
		
		tempMap = move(x, y, tempMap);
		boolean nextCheck = false;
		int nx = x;
		int ny = y;
		while(true) {
			nx += dx[d];
			ny += dy[d];
			if(0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
				if(tempMap[nx][ny][0] != 0) {
					nextCheck = true;
					dfs(nx, ny, sum, tempMap);
				}
				else
					continue;
			}
			else
				break;
		}
		if(!nextCheck)
			ans = Math.max(ans, sum);
	}

	private static int[][][] move(int sharkX, int sharkY, int[][][] map) {
		int numCheck = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				numCheck++;
				w: for(int k = 0; k < 4; k++) {
					for(int l = 0; l < 4; l++) {
						if(map[k][l][0] == numCheck) {
							int x = k;
							int y = l;
							int d = map[k][l][1];
							int num = map[k][l][0];
							for(int m = 0; m < 8; m++) {
								int nx = x + dx[d];
								int ny = y + dy[d];
								//이 방향으로 갈 수 있다면
								if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && !(nx == sharkX && ny == sharkY)) {
									if(map[nx][ny][0] == 0) {
										map[nx][ny][0] = num;
										map[nx][ny][1] = d;
										map[x][y][0] = 0;
										map[x][y][1] = 0;
										break w;
									}
									else {
										int tempNum = map[nx][ny][0];
										int tempD = map[nx][ny][1];
										map[nx][ny][0] = num;
										map[nx][ny][1] = d;
										map[x][y][0] = tempNum;
										map[x][y][1] = tempD;
										break w;
									}
								}
								//못가면 45도 회전
								else {
									d = turn(d);
								}							
							}
						}
					}
				}
			}
		}
		
		return map;
	}

	private static int turn(int distance) {
		if(distance == 7)
			return 0;
		else
			return distance + 1;
	}

}