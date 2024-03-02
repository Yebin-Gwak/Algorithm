import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static Deque<Integer> marbles = new ArrayDeque<>();
	static int sharkX, sharkY;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int score = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		sharkX = sharkY = (N + 1) / 2 - 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			cast(d, s);
			getMarble();
			explosion();
			initMap();
			change();
			setMarble();
		}
		
		System.out.println(score);
	}



	private static void initMap() {
		for(int[] m : map)
			Arrays.fill(m, 0);		
	}

	private static void cast(int d, int s) {
		int nx = sharkX;
		int ny = sharkY;
		for (int i = 0; i < s; i++) {
			nx += dx[d];
			ny += dy[d];
			map[nx][ny] = -1;
		}

	}

	private static void getMarble() {
		int recur = (N - 1) / 2;
		for (int s = 0; s < recur; s++) {
			int nx = sharkX - s;
			int ny = sharkY - s - 1;

			// 아래
			for (int i = 0; i < (s + 1) * 2; i++) {
				if (map[nx][ny] == 0)
					return;
				if (map[nx][ny] > 0)
					marbles.add(map[nx][ny]);
				nx++;
			}

			nx--;
			ny++;

			// 오른쪽
			for (int i = 0; i < (s + 1) * 2; i++) {
				if (map[nx][ny] == 0)
					return;
				if (map[nx][ny] > 0)
					marbles.add(map[nx][ny]);
				ny++;
			}

			ny--;
			nx--;

			for (int i = 0; i < (s + 1) * 2; i++) {
				if (map[nx][ny] == 0)
					return;
				if (map[nx][ny] > 0)
					marbles.add(map[nx][ny]);
				nx--;
			}

			nx++;
			ny--;

			for (int i = 0; i < (s + 1) * 2; i++) {
				if (map[nx][ny] == 0)
					return;
				if (map[nx][ny] > 0)
					marbles.add(map[nx][ny]);
				ny--;
			}
		}

	}

	private static void explosion() {
		Deque<Integer> nextMarbles;
		
		boolean boom = true;
		while(boom) {
			nextMarbles = new ArrayDeque<>();
			//폭발 없었으면 리트 안함
			boom = false;
			
			while(!marbles.isEmpty()) {

				int now = marbles.peek();
				int count = 0;
					
				//같은 개수 찾기
				while(!marbles.isEmpty()) {
					if(marbles.peekFirst() != now)
						break;
					count++;
					marbles.poll();
				}
					
				if(count < 4) {
					for(int i = 0; i < count; i++) {
						nextMarbles.add(now);
					}
				}
				else {
					boom = true;
					score += now * count;
				}
					

				
			}
			
			marbles = nextMarbles;
		}
		
	}

	private static void change() {
		Deque<Integer> nextMarbles = new ArrayDeque<>();
		int maxSize = (N * N) - 1;
		
		while(!marbles.isEmpty()) {

			int now = marbles.peek();
			int count = 0;
				
			//같은 개수 찾기
			while(!marbles.isEmpty()) {
				if(marbles.peekFirst() != now)
					break;
				count++;
				marbles.poll();
			}
				
			//count 3까지 돌면 어차피 멈추고 여기로 내려옴
			
			nextMarbles.add(count);
			if(nextMarbles.size() == maxSize) {
				marbles = nextMarbles;
				return;
			}
			nextMarbles.add(now);
			if(nextMarbles.size() == maxSize) {
				marbles = nextMarbles;
				return;
			}
			
				

			
		}
		marbles = nextMarbles;

	}

	private static void setMarble() {
		int recur = (N - 1) / 2;
		for (int s = 0; s < recur; s++) {
			int nx = sharkX - s;
			int ny = sharkY - s - 1;

			// 아래
			for (int i = 0; i < (s + 1) * 2; i++) {
				if (marbles.isEmpty())
					return;
				map[nx][ny] = marbles.poll();
				nx++;
			}

			nx--;
			ny++;

			// 오른쪽
			for (int i = 0; i < (s + 1) * 2; i++) {
				if (marbles.isEmpty())
					return;
				map[nx][ny] = marbles.poll();
				ny++;
			}

			ny--;
			nx--;

			for (int i = 0; i < (s + 1) * 2; i++) {
				if (marbles.isEmpty())
					return;
				map[nx][ny] = marbles.poll();
				nx--;
			}

			nx++;
			ny--;

			for (int i = 0; i < (s + 1) * 2; i++) {
				if (marbles.isEmpty())
					return;
				map[nx][ny] = marbles.poll();
				ny--;
			}
		}
	}
}