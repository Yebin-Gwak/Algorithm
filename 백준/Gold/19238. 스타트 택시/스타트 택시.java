import java.util.*;
import java.io.*;

public class Main {
	static class Taxi{
		int x, y, fuel;
		
		public Taxi(int x, int y, int fuel) {
			super();
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}
		
	}
	
	static class Passenger implements Comparable<Passenger>{
		int x, y, destX, destY, destDistance;

		public Passenger(int x, int y, int destX, int destY) {
			this.x = x;
			this.y = y;
			this.destX = destX;
			this.destY = destY;
			this.destDistance = Math.abs(this.x - destX) + Math.abs(this.y - destY);
		}

		@Override
		public int compareTo(Passenger o) {
			if(this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
		
		
	}
	
	static Taxi taxi;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, F;
	static int[][] map;
	static Passenger[][] pMap;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	static PriorityQueue<Passenger> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		pMap = new Passenger[N][N];
		
		initMap();
		initTaxi();
		initPassenger();
		
		for(int i = 0; i < M; i++) {
			moveToPassenger();
			moveToDest();
		}
		System.out.println(taxi.fuel);
		
	}



	private static void initMap() throws IOException {
		map = new int[N][N];
		pMap = new Passenger[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
	}



	private static void initTaxi() throws IOException {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		taxi = new Taxi(x, y, F);
	}
	
	private static void initPassenger() throws IOException {
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int destX = Integer.parseInt(st.nextToken()) - 1;
			int destY = Integer.parseInt(st.nextToken()) - 1;
			pMap[x][y] = new Passenger(x, y, destX, destY);
		}
		
	}
	
	private static void moveToPassenger() {
		Deque<int[]> deque = new ArrayDeque<>();
		visited = new boolean[N][N];
		deque.add(new int[] {taxi.x, taxi.y});
		visited[taxi.x][taxi.y] = true;
		if(pMap[taxi.x][taxi.y] != null) {
			pq.add(pMap[taxi.x][taxi.y]);
			return;
		}
		
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int s = 0; s < size; s++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});
						if(pMap[nx][ny] != null)
							pq.add(pMap[nx][ny]);
					}
				}
				
			}
			if(--taxi.fuel == 0) 
				fail();
			
			if(!pq.isEmpty())
				return;
		}
		fail();
	}
	
	
	private static void moveToDest() {
		Passenger p = pq.poll();
		taxi.x = p.x;
		taxi.y = p.y;
		
		Deque<int[]> deque = new ArrayDeque<>();
		visited = new boolean[N][N];
		deque.add(new int[] {taxi.x, taxi.y});
		visited[taxi.x][taxi.y] = true;
		
		int startFuel = taxi.fuel;
		
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int s = 0; s < size; s++) {
				int[] temp = deque.poll();
				int x = temp[0];
				int y = temp[1];
				if(x == p.destX && y == p.destY) {
					taxi.fuel += (startFuel - taxi.fuel) * 2;
					taxi.x = p.destX;
					taxi.y = p.destY;
					pMap[p.x][p.y]= null;
					pq.clear();
					return;
				}
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] {nx, ny});
					}
				}
				
			}
			if(--taxi.fuel < 0)
				fail();
			
		}
		fail();

	}
	
	private static void fail() {
		System.out.println(-1);
		System.exit(0);
	}

}