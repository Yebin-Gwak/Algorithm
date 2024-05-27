import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static int L, D, K;
	static int[][] map;
	static Deque<Integer> turnDeque = new ArrayDeque<>();
	static Deque<int[]> removeDeque = new ArrayDeque<>();
	static boolean[][] visited;
	static boolean[] removed;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < T; i++) {
			turn();
			remove();
			check();
		}
		
		int ans = 0;
		for(int[] x : map) {
			for(int y : x) {
				ans += y;
			}
		}
		System.out.println(ans);
	}



	private static void turn() throws IOException {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 배수만큼 돌려
		for(int i = L - 1; i < N; i += L) {
			// 해당 원판의 모든 수 덱에 저장
			for(int x : map[i])
				turnDeque.add(x);
			// 덱 회전시켜서
			for(int k = 0; k < K; k++) {
				if(D == 0)
					turnDeque.addFirst(turnDeque.pollLast());
				else
					turnDeque.addLast(turnDeque.pollFirst());			
			}
			// 다시 원판에 저장
			for(int j = 0; j < M; j++)
				map[i][j] = turnDeque.poll();
		}
	}

	private static void remove() {
		visited = new boolean[N][M];
		removed = new boolean[N];
		// 올라가면서 체크해줄거임. 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				//옆체크
				if(map[i][j] == map[i][(j + 1) % M]) {
					removed[i] = true;
					if(!visited[i][j]) {
						visited[i][j] = true;
						removeDeque.add(new int[] {i, j});						
					}
					if(!visited[i][(j + 1) % M]) {
						visited[i][(j + 1) % M] = true;
						removeDeque.add(new int[] {i, (j + 1) % M});
					}
				}
				if(i == N - 1) continue;
				//다음원판 체크
				if(map[i][j] == map[i + 1][j]) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						removeDeque.add(new int[] {i, j});						
					}
					
					visited[i + 1][j] = true;
					removed[i + 1] = true;
					removeDeque.add(new int[] {i + 1, j});
				}
				
				
			}
		}
		
		while(!removeDeque.isEmpty()) {
			int[] temp = removeDeque.poll();
			map[temp[0]][temp[1]] = 0;
		}
		
	}
	
	private static void check() {
		for(boolean x : removed)
			if(x) return;
		
		int value = 0;
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				value += map[i][j];
				count++;
			}
		}


			
		if(count == 0) return;

		double v = (double)value / count;
			
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 || map[i][j] == v) continue;
				map[i][j] = (map[i][j] > v) ? map[i][j] - 1 : map[i][j] + 1;
			}
		}
	
	}

}