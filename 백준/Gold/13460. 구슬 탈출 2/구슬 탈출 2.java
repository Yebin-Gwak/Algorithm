import java.util.*;
import java.io.*;

public class Main {
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static Pos red, blue;
	static Deque<Pos[]> deque = new ArrayDeque<>();
	static int d = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int time = 0;
	static Pos[] now;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = data.charAt(j);
				if(c == 'R') {
					red = new Pos(i, j);
					map[i][j] = '.';
				}
				else if(c == 'B') {
					blue = new Pos(i, j);
					map[i][j] = '.';
				}
				else
					map[i][j] = c;
			}
		}
		
		bfs();
		
	}

	private static void bfs() {
		deque.add(new Pos[] {red, blue});
		visited[red.x][red.y][blue.x][blue.y]= true; 
		
		while(++time <= 10) {
			int size = deque.size();
			for(int t = 0; t < size; t++) {
				now = deque.poll();
				for(int i = 0; i < 4; i++) {
					red = now[0];
					blue = now[1];
					d = i;
					Pos[] l = play();
					
					if(l != null)
						deque.add(l);
				}
			}
		}
		System.out.println(-1);
	}

	private static Pos[] play() {
		map[red.x][red.y] = 'R';
		map[blue.x][blue.y] = 'B';
		
		boolean redTurn = true;
		if(d == 0 && blue.x < red.x) redTurn = false;
		if(d == 1 && blue.x > red.x) redTurn = false;
		if(d == 2 && blue.y < red.y) redTurn = false;
		if(d == 3 && blue.y > red.y) redTurn = false;
		
		Pos resultR;
		Pos resultB;
		boolean goalRed = false;
		
		if(redTurn) {
			map[red.x][red.y] = '.';
			resultR = move(red);
			if(resultR != null)
				map[resultR.x][resultR.y] = 'R';
			resultB = move(blue);
			if(resultR != null)
				map[resultR.x][resultR.y] = '.';
			map[blue.x][blue.y] = '.';
			if(resultB == null)
				return null;
		}
		else {
			map[blue.x][blue.y] = '.';
			resultB = move(blue);
			if(resultB == null) {
				map[red.x][red.y] = '.';
				return null;
			}
			map[resultB.x][resultB.y] = 'B';
			map[red.x][red.y]= '.'; 
			resultR = move(red);
			map[resultB.x][resultB.y] = '.';
		}
		
		if(resultR == null) {
			System.out.println(time);
			System.exit(0);
		}
		if(visited[resultR.x][resultR.y][resultB.x][resultB.y])
			return null;
		
		visited[resultR.x][resultR.y][resultB.x][resultB.y] = true;
		return new Pos[] {resultR, resultB};
	}

	private static Pos move(Pos ball) {
		int x = ball.x;
		int y = ball.y;
		if(d < 2) {
			while (true) {
				x += dx[d];
				if(map[x][y] == '.')
					continue;
				
				if (map[x][y] == 'O')
					return null;
				
				if(Math.abs(ball.x - x) == 1)
					return ball;
				return (d == 0) ? new Pos(x + 1, y) : new Pos(x - 1, y);
			}
		}
		else {
			while (true) {
				y += dy[d];
				if(map[x][y] == '.')
					continue;
				
				if (map[x][y] == 'O')
					return null;
				
				if(Math.abs(ball.y - y) == 1)
					return ball;
				return (d == 2) ? new Pos(x, y + 1) : new Pos(x, y - 1);
			}
		}

	}
}