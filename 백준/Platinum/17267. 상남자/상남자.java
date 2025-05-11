import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int x, y, l, r;

		public Node(int x, int y, int l, int r) {
			this.x = x;
			this.y = y;
			this.l = l;
			this.r = r;
		}

		@Override
		public int compareTo(Node o) {
			return (this.l + this.r) - (o.l + o.r);
		}
		
		public int cost(){
			return l + r;
		}

	}
	
	static int N, M, L, R;
	static int[][] map;
	static int[] limX, limY;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		limX = new int[] {-1, N};
		limY = new int[] {-1, M};
		
		int x = 0;
		int y = 0;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				int n = s.charAt(j) - '0';
				map[i][j] = n;
				if(n == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		System.out.println(dijkstra(x, y));
		
	}
	private static int dijkstra(int sx, int sy) {
		boolean[][] visited = new boolean[N][M];
		int[][] distances = new int[N][M];
		for(int i = 0; i < N; i++)
			Arrays.fill(distances[i], Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distances[sx][sy] = 0;
		pq.add(new Node(sx, sy, 0, 0));
		
		int[] dxdy = new int[] {-1, 1};
		int[] dl = new int[] {1, 0};
		int[] dr = new int[] {0, 1};
		
		int ans = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.cost() != distances[now.x][now.y])
				continue;
			
			if(!visited[now.x][now.y]) {
				visited[now.x][now.y] = true;
				ans++;
			}
			
			for(int i = 0; i < 2; i++) {
				int nx = now.x + dxdy[i];
				while(nx != limX[i]) {
					if(visited[nx][now.y] || map[nx][now.y] == 1)
						break;
					if(now.cost() < distances[nx][now.y]) {
						distances[nx][now.y] = now.cost();
						pq.add(new Node(nx, now.y, now.l, now.r));
					}
					nx += dxdy[i];
				}
			}
			
			for(int i = 0; i < 2; i++) {
				int ny = now.y + dxdy[i];
				int nl = now.l + dl[i];
				int nr = now.r + dr[i];
				if(nl > L || nr > R)
					continue;
				if(0<= ny && ny < M && !visited[now.x][ny] && map[now.x][ny] != 1 && now.cost() < distances[now.x][ny]) {
					distances[now.x][ny] = nl + nr;
					pq.add(new Node(now.x, ny, nl, nr));
				}
			}
			
		}
		
		return ans;
		
	}

}
