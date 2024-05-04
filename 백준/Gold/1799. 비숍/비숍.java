import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
	static int N;
	static boolean[][] visited;
	static int blackMax = 0;
	static int whiteMax = 0;
	static int[] dy = {-1, 1};
	static Deque<Point> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 0)
					visited[i][j] = true;
			}
		}
		dfs(0, 0, 0);
		dfs(0, 1, 0);
		System.out.println(blackMax + whiteMax);
	}

	private static void dfs(int x, int y, int cnt) {
		if(y >= N) {
			x++;
			y = (y % 2 == 0) ? 1 : 0;
		}
		
 		if(x == N) {
 			if(y == 0)
 				blackMax = Math.max(blackMax, cnt);
 			else
 				whiteMax = Math.max(whiteMax, cnt);
			return;
		}
		
		if(visited[x][y]) {
			dfs(x, y + 2, cnt);
			return;
		}
		
		int size = deque.size();
		visit(x, y);
		dfs(x, y + 2, cnt + 1);
		unVisit(deque.size() - size);
		dfs(x, y + 2, cnt);
	}

	private static void visit(int x, int y) {
		visited[x][y] = true;
		deque.add(new Point(x, y));
		
		for(int i = 0; i < 2; i++) {
			int nx = x;
			int ny = y;
			while(true) {
				nx++;
				ny += dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new Point(nx, ny));
					}
					continue;
				}
				break;
			}
		}
	}
	
	private static void unVisit(int size) {
		for(int i = 0; i < size; i++) {
			Point p = deque.pollLast();
			visited[p.x][p.y] = false;
		}
	}
}
