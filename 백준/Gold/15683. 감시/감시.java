import java.util.*;
import java.io.*;

public class Main {
	static int N, M, camCount, zeroCount;
	static int[] numbers = {0, 1, 2 ,3};
	static int[] input;
	
	static Deque<int[]> deque = new ArrayDeque<int[]>();
	
	static int[][] map;
	static boolean[][] initVisited;
	static boolean[][] visited;
	static int ans = Integer.MAX_VALUE;
	
	
	static List<int[]> cams = new ArrayList<int[]>();
	
	
	static int[][][][] turn = {
			{
				{{0, 1}},
				{{1, 0}},
				{{0, -1}},
				{{-1, 0}}
			},
			
			{
				{{0, 1}, {0, -1}},
				{{1, 0}, {-1, 0}},
				{{0, 1}, {0, -1}},
				{{1, 0}, {-1, 0}}
			},
			
			{
				{{-1, 0}, {0, 1}},
				{{0, 1}, {1, 0}},
				{{1, 0}, {0, -1}},
				{{0, -1}, {-1, 0}}
				
			},
			
			{
				{{0, -1}, {-1, 0}, {0, 1}},
				{{-1, 0}, {0, 1}, {1, 0}},
				{{0, 1}, {1, 0}, {0, -1}},
				{{1, 0}, {0, -1}, {-1, 0}},
			
			},
			
			{
				{{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
				{{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
				{{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
				{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
			}
			
			
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		initVisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				
				if(value == 0) zeroCount++;
				else {
					initVisited[i][j] = true; // 카메라, 벽이 놓인 곳은 사각지대로 카운트 x
					if(value != 6) {
						cams.add(new int[] {i, j, value - 1});
						camCount++;											
					}
				}
				
			}
			
		}
		
		input = new int[camCount];
		
		중복순열(0);
		
		while(!deque.isEmpty())
			simulation();

		System.out.println(ans);
		
	}
	
	private static void simulation() {
		int[] turns = deque.poll(); // 각 카메라들의 방향 정보가 담긴 경우의 수 하나 추출
		visited = new boolean[N][];
		
		for(int i = 0; i < N; i++)
			visited[i] = initVisited[i].clone();
		
		for(int i = 0; i < camCount; i++) { //카메라 수 만큼 반복
			int[] camera = cams.get(i);
			lookAround(camera[0], camera[1], camera[2], turns[i]); // 카메라의 좌표, 카메라의 종류, 카메라가 보는 방향을 매개변수로 전달
		}
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				if(!visited[i][j]) result++;
		}
		
		ans = Math.min(ans, result);
		
	}
	
	private static void lookAround(int x, int y, int type, int d) {
		for(int i = 0; i < turn[type][d].length; i++) {
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += turn[type][d][i][0];
				ny += turn[type][d][i][1];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 6) { // 인덱스 범위 내 이고, 벽이 아니라면
					if(!visited[nx][ny])
						visited[nx][ny] = true;
				}
				else
					break;
			}
		}
		
	}

	// 4의 (camCount)승 중복순열 추출
	
	private static void 중복순열(int cnt) {
		if(cnt == camCount) {
			int[] temp = input.clone();
			deque.add(temp);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			input[cnt] = numbers[i];
			중복순열(cnt + 1);
		}
		
		
	}

}