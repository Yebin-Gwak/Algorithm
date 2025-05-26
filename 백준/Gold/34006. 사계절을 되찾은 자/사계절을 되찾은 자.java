import java.io.*;
import java.util.*;

public class Main {
	static class Log{
		int A;
		int B;
		int C;
		
		public Log(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
		
	}
	
	static int N, A, B, C, a, b, c;
	static boolean[][] visited;
	static char[][] routes;
	static int[][][] parents;
	static StringBuilder sb =  new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int t = bfs();
		System.out.println(t);
		if(t != -1) {
			getRoute(N, N);
			System.out.println(sb.reverse().toString().trim());
		}
		
	}
	
	private static void getRoute(int A, int B) {
		if(A == -1 && B == -1)
			return;
		sb.append(routes[A][B]);
		getRoute(parents[A][B][0], parents[A][B][1]);
	}

	private static int bfs() {
		visited = new boolean[N * 2 + 1][N * 2 + 1];
		parents = new int[N * 2 + 1][N * 2 + 1][2];
		routes = new char[N * 2 + 1][N * 2 + 1];
		visited[A][B] = true;
		parents[A][B][0] = parents[A][B][1] = -1;
		
		ArrayDeque<Log> dq = new ArrayDeque<>();
		dq.add(new Log(A, B, C));
		
		int time = 0;
		while(!dq.isEmpty()) {
			int size = dq.size();
			for(int i = 0; i < size; i++) {
				Log now = dq.poll();
				if(now.A == N && now.B == N && now.C == N)
					return time;
				
				if(now.A + a < 2 * N && now.C - a > 0 && !visited[now.A + a][now.B]) {
					visited[now.A + a][now.B] = true;
					parents[now.A + a][now.B][0] = now.A;
					parents[now.A + a][now.B][1] = now.B;
					routes[now.A + a][now.B] = 'A';
					dq.add(new Log(now.A + a, now.B, now.C - a));
				}
				
				if(now.B + b < 2 * N && now.A - b > 0 && !visited[now.A - b][now.B + b]) {
					visited[now.A - b][now.B + b] = true;
					parents[now.A - b][now.B + b][0] = now.A;
					parents[now.A - b][now.B + b][1] = now.B;
					routes[now.A - b][now.B + b] = 'B';
					dq.add(new Log(now.A - b, now.B + b, now.C));
				}
				
				if(now.C + c < 2 * N && now.B - c > 0 && !visited[now.A][now.B - c]) {
					visited[now.A][now.B - c] = true;
					parents[now.A][now.B - c][0] = now.A;
					parents[now.A][now.B - c][1] = now.B;
					routes[now.A][now.B - c] = 'C';
					dq.add(new Log(now.A, now.B - c, now.C + c));
				}
				
			}
			time++;
		}
		return -1;
		
	}

}