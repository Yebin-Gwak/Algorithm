import java.util.*;
import java.io.*;

public class Main {
	static class Zombie{
		int x, y, d;

		public Zombie(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Zombie [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
		
		
	}
	
	static class Ahri{
		int x, y, d;

		public Ahri(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ahri [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
		
		
	}
	
	static int N;
	
	static Ahri ahri = new Ahri(0, 0, 0);
	static List<Zombie> zombies = new ArrayList<>();
	static boolean[][] lightSwitch;
	static boolean[][] light;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int[] aroundX = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] aroundY = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lightSwitch = new boolean[N][N];
		light = new boolean[N][N];
		
		String cmd = br.readLine();
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < N; j++) {
				char c = data.charAt(j);
				if(c == 'Z')
					zombies.add(new Zombie(i, j, 0));
				else if(c == 'S')
					lightSwitch[i][j] = true;
			}
		}
		
		// 아리 이동
		// 스위치 있으면 불켜기
		// 좀비 겹치는지 확인
		// 좀비 이동
		// 좀비 겹치는지 확인
		
		for(int i = 0; i < cmd.length(); i++) {
			char c = cmd.charAt(i);
			if(c == 'F') {
				move();
				hitCheck();
			}
			else
				turn(c);
			
			zombieMove();
			hitCheck();
		}
		
		System.out.println("Phew...");
		
	}

	private static void move() {
		int nx = ahri.x + dx[ahri.d];
		int ny = ahri.y + dy[ahri.d];
		
		if(0 <= nx && 0 < N && 0 <= ny && ny < N) {
			ahri.x = nx;
			ahri.y = ny;
			
			lightCheck();
		}
		
	}


// 아래 위 오른쪽 왼쪽
	private static void turn(char c) {
		int d = ahri.d;
		
		if(c == 'L') {
			if(d == 0)
				d = 2;
			else if(d == 1)
				d = 3;
			else if(d == 2)
				d = 1;
			else
				d = 0;
			
		}
		else {
			if(d == 0)
				d = 3;
			else if(d == 1)
				d = 2;
			else if(d == 2)
				d = 0;
			else
				d = 1;
		}
		ahri.d = d;
	}
	
	private static void lightCheck() {
		int x = ahri.x;
		int y = ahri.y;
		if(lightSwitch[x][y]) {
			lightSwitch[x][y] = false;
			light[x][y] = true;
			for(int i = 0; i < 8; i++) {
				int nx = x + aroundX[i];
				int ny = y + aroundY[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					light[nx][ny] = true;
				}
			}
			
			
		}
		
	}

	
	private static void zombieMove() {
		for(Zombie z : zombies) {
			int nx = z.x + dx[z.d];
			if(0 <= nx && nx < N)
				z.x = nx;
			else
				z.d = (z.d == 0) ? 1 : 0;
		}
		
	}
	
	private static void hitCheck() {
		int x = ahri.x;
		int y = ahri.y;
		if(light[x][y]) return;
		
		for(Zombie z : zombies) {
			if(z.x == x && z.y == y) {
				System.out.println("Aaaaaah!");
				System.exit(0);
			}
		}
		
	}
}