import java.util.*;
import java.io.*;

public class Main {
	static class Virus{
		int num, x, y;

		public Virus(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}	
	}
	
	static int N, K, S, X, Y;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Deque<Virus> deque = new ArrayDeque<Virus>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		List<Virus> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v != 0) {
					list.add(new Virus(v, i, j));
				}
			}
		}
		list.sort((o1, o2) -> o1.num - o2.num);
		for(Virus v : list) {
			deque.add(v);
			visited[v.x][v.y] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		Y = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();
		System.out.println(map[X][Y]);

	}

	private static void bfs() {
		while(--S >= 0) {
			int size = deque.size();
			for(int k = 0; k < size; k++) {
				Virus v = deque.poll();
				if(v.x == X && v.y == Y) 
					return;
				
				int x = v.x;
				int y = v.y;
				for(int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = v.num;
						deque.add(new Virus(v.num, nx, ny));
					}
				}
			}
		}
		
	}
}
