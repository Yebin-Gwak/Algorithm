import java.util.*;
import java.io.*;

public class Main {
	static class Virus{
		int x, y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int virusCount = 0;
	static int zeroCount = 0;
	static List<Virus> vList = new ArrayList<>();
	static Virus[] viruses;
	static int[] input;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init();

		comb(0, 0);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
		
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			bfs(input.clone());
			return;
		}
		
		for(int i = start; i < virusCount; i++) {
			input[cnt] = i;
			comb(i + 1, cnt + 1);
		}
		
	}

	private static void bfs(int[] activation) {
		visited = new boolean[N][N];
		Deque<Virus> deque = new ArrayDeque<>();
		for(int x : activation) {
			Virus v = viruses[x];
			visited[v.x][v.y] = true;
			deque.add(v);
		}
		int cnt = zeroCount;
		int time = 0;
		
		while(!deque.isEmpty()) {
			time++;
			int size = deque.size();
			for(int t = 0; t < size; t++) {
				Virus v = deque.poll();
				int x = v.x;
				int y = v.y;
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new Virus(nx, ny));
						if(map[nx][ny] == 0) {
							cnt--;
							if(cnt == 0) {
								ans = Math.min(ans, time);
								return;
							}
						}
					}
				}
				
			} 
		}

	}

	
	
	private static void init() throws IOException {
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == 0)
					zeroCount++;
				else if(value == 2) {
					vList.add(new Virus(i, j));
				}
			}
		}
		
		if(zeroCount == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		virusCount = vList.size();
		
		viruses = new Virus[virusCount];
		for(int i = 0; i < virusCount; i++)
			viruses[i] = vList.get(i);
		
		input = new int[M];
		
	}
	
}