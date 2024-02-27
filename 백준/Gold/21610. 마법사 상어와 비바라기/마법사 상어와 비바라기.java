import java.util.*;
import java.io.*;

public class Main {

	static class Cloud {
		int x, y;

		public Cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Cloud [x=" + x + ", y=" + y + " ]";
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, D, S;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[][][] map;

	static List<Cloud> clouds = new ArrayList<>();

	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = N - 2; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				clouds.add(new Cloud(i, j));
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()) - 1;
			S = Integer.parseInt(st.nextToken());
			
			moveAndRainy();
			bug();
			makeCloud();
		}
		
		calc();
		
		System.out.println(ans);
		
	}

	private static void moveAndRainy() {
		int nx;
		int ny;
		
		for(Cloud cloud : clouds) {
			nx = cloud.x + (S * dx[D]);
			ny = cloud.y + (S * dy[D]);
			
			if(nx < 0) while(nx < 0) nx += N;
			if(ny < 0) while(ny < 0) ny += N;
			if(nx >= N) while(nx >= N) nx -= N;
			if(ny >= N) while(ny >= N) ny -= N;
			
			cloud.x = nx;
			cloud.y = ny;
			
			map[nx][ny][0] += 1; // 비내려서 물 증가
			map[nx][ny][1] = 1; // 여기 구름있어요
		}
	}

	private static void bug() {
		int nx;
		int ny;
		
		for(Cloud cloud : clouds) {
			for(int i = 1; i <= 7; i += 2) {
				nx = cloud.x + dx[i];
				ny = cloud.y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny][0] > 0) {
					map[cloud.x][cloud.y][0] ++;
				}
			}
		}

	}

	private static void makeCloud() {
		clouds.clear();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j][1] == 1) { // 구름 있던곳은
					map[i][j][1] = 0; // 진행 안하고 기존 구름 흔적 지워주기
					continue;
				}
				if(map[i][j][0] > 1) {
					map[i][j][0] -= 2;
					clouds.add(new Cloud(i, j));
				}
			}
		}
		
	}

	private static void calc() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ans += map[i][j][0];
			}
		}
		
	}

}