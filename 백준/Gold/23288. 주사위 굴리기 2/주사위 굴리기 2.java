import java.util.*;
import java.io.*;

public class Main {
	static class Dice{
		static int top;
		static Deque<Integer> row = new ArrayDeque<>();
		static Deque<Integer> col = new ArrayDeque<>();
		
		Dice(){
			top = 1;
			row.addLast(4);
			row.addLast(3);
			
			col.addLast(2);
			col.addLast(5);
			col.addLast(6);
			
		}
		
		public void turn(int d) {
			int temp = top;
			if(d == 0) {
				top = row.pollFirst();
				row.addFirst(col.pollLast());
				col.addLast(row.pollLast());
				row.addLast(temp);
			}
			else if(d == 1) {
				top = row.pollLast();
				row.addLast(col.pollLast());
				col.addLast(row.pollFirst());
				row.addFirst(temp);
			}
			else if(d == 2) {
				top = col.pollFirst();
				col.addFirst(temp);
				col.addFirst(col.pollLast());
			}
			else if(d == 3) {
				col.addLast(col.pollFirst());
				top = col.pollFirst();
				col.addFirst(temp);
			}
		}
		
		public int getUnder() {
			return col.peekLast();
		}
		
	}
	
	static int under;
	
	// 동서남북
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static int D;
	static int N, M, K, X, Y;
	static int[][] map;
	static boolean[][] visited;
	
	static Deque<int[]> deque;
	static int ans = 0;
	
	static Dice dice = new Dice();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		X = 0;
		Y = 0;
		D = 0;
		for(int i = 0; i < K; i++) {
			move();
			calc();
			turn();
		}
		System.out.println(ans);
		
		
	}
	private static void move() {
		int nx = X + dx[D];
		int ny = Y + dy[D];
		
		if(!(0 <= nx && nx < N && 0 <= ny && ny < M)) {
			if(D == 0)
				D = 1;
			else if(D == 1)
				D = 0;
			else if(D == 2)
				D = 3;
			else if(D == 3)
				D = 2;
		}
		X += dx[D];
		Y += dy[D];
		dice.turn(D);
		under = dice.getUnder();
		
	}
	private static void calc() {
		visited = new boolean[N][M];
		deque = new ArrayDeque<>();
		deque.add(new int[] {X, Y});
		visited[X][Y] = true;
		
		int num = map[X][Y];
		
		int point = 1;
		while(!deque.isEmpty()) {
			int[] temp = deque.poll();
			int x = temp[0];
			int y = temp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == num && !visited[nx][ny]) {
					deque.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					point++;
				}
			}
			
		}
		ans += num * point;
		
	}
	private static void turn() {
		if(under == map[X][Y]) return;
		if(under > map[X][Y]) {
			if(D == 0)
				D = 2;
			else if(D == 1)
				D = 3;
			else if(D == 2)
				D = 1;
			else if(D == 3)
				D = 0;
		}
		else {
			if(D == 0)
				D = 3;
			else if(D == 1)
				D = 2;
			else if(D == 2)
				D = 0;
			else if(D == 3)
				D = 1;
		}
		
	}

}
