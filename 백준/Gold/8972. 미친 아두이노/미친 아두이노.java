import java.util.*;
import java.io.*;

public class Main {
	static class Robot{
		int x;
		int y;
		int d;
		int value;
		public Robot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public void find() {
			value = 100000;
			for(int i = 0; i < 9; i++) {
				if(i == 4)
					continue;
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				int v = Math.abs(X - nx) + Math.abs(Y - ny);
				if(v < value) {
					this.value = v;
					this.d = i;
				}
			}
			this.x += dx[d];
			this.y += dy[d];
		}	
	}
	
	static int N, M;
	static char[][] map;
	static Deque<Robot>[][] robots;
	static int X, Y;
	static int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	static Deque<Robot> next = new ArrayDeque<>();
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		robots = new Deque[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				robots[i][j] = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = data.charAt(j);
				if(c == 'I') {
					X = i;
					Y = j;
				}
				if(c == 'R') {
					robots[i][j].add(new Robot(i, j));
				}
			}
		}
		
		String cmd = br.readLine();
		for(int i = 0; i < cmd.length(); i++) {
			count++;
			move(cmd.charAt(i) - '0');
			check();
			chase();
			check();
			boom();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = (robots[i][j].isEmpty()) ? '.' : 'R';
			}
		}
		map[X][Y] = 'I';
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		
		
	}
	private static void move(int d) {
		X += dx[d - 1];
		Y += dy[d - 1];
	}
	private static void chase() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(robots[i][j].isEmpty())
					continue;
				while(!robots[i][j].isEmpty()) {
					Robot robot = robots[i][j].poll();
					robot.find();
					next.add(robot);
				}
			}
		}
		
		while(!next.isEmpty()) {
			Robot r = next.poll();
			robots[r.x][r.y].add(r);
		}
	}
	private static void check() {
		if(!robots[X][Y].isEmpty()) {
			System.out.println("kraj " + count);
			System.exit(0);
		}
	}
	
	private static void boom() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				if(robots[i][j].size() >= 2)
					robots[i][j].clear();
		}
	}

}