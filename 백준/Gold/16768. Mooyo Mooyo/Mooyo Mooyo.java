import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int N, K;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static List<List<int[]>> groups = new ArrayList<>();
	static boolean[][] visited;
	static boolean boom = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][10];
		for(int i = 0; i < N; i++) {
			String data = br.readLine();
			for(int j = 0; j < 10; j++)
				map[i][j] = data.charAt(j) - '0';
		}
		
		while(true) {
			visited = new boolean[N][10];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 10; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						List<int[]> list = bfs(i, j);
						if(list != null)
							groups.add(list);
					}
				}
			}
			if(groups.isEmpty())
				break;
			boom();
			drop();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static List<int[]> bfs(int startX, int startY) {
		int num = map[startX][startY];
		Deque<int[]> deque = new ArrayDeque<int[]>();
		List<int[]> group = new ArrayList<int[]>();
		
		deque.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		while(!deque.isEmpty()) {
			int[] now = deque.poll();
			group.add(now);
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < 10 && map[nx][ny] == num && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deque.add(new int[] {nx, ny});
					
				}
			}
		}
		
		return (group.size() >= K) ? group : null;
	}

	private static void boom() {
		for(List<int[]> group : groups) {
			for(int[] now : group)
				map[now[0]][now[1]] = 0;
		}
		groups.clear();
		
	}

	private static void drop() {
		for(int i = N - 2; i >= 0; i--) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 0)
					continue;
				int color = map[i][j];
				int x = i;
				int y = j;
				int h = 0;
				boolean hitBlock = false;
				boolean hitGround = false;
				while (true) {
					h++;
					if (map[x + h][y] > 0)
						hitBlock = true;
					if (x + h == N - 1)
						hitGround = true;
					if (hitBlock) {
						map[x][y] = 0;
						map[x + h - 1][y] = color;
						break;
					}
					if (hitGround) {
						map[x][y] = 0;
						map[x + h][y] = color;
						break;
					}

				}
				
			}
		}
	}



}