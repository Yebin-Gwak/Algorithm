import java.util.*;
import java.io.*;

public class Main {
	static class Mal{
		int x, y, d;

		public Mal(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static int N, K;
	static ArrayList<Mal> mList;
	static List<LinkedList<Mal>>[] mMap;
	static int[][] map;
	
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		initMap();
		initMal();
		
		play();
		
	}

	private static void initMap() throws IOException {
		// 맵 테두리는 2로 감싸줌
		map = new int[N + 2][N + 2];
		Arrays.fill(map[0], 2);
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = 2;
			for(int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
			map[i][N + 1] = 2;
		}
		Arrays.fill(map[N + 1], 2);
	}
	
	private static void initMal() throws IOException {
		mList = new ArrayList<>();
		mMap = new List[N + 2];
		for(int i = 0; i < N + 2; i++) {
			mMap[i] = new ArrayList<LinkedList<Mal>>();
			for(int j = 0; j < N + 2; j++)
				mMap[i].add(new LinkedList<>());
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Mal m = new Mal(x, y, d);
			mList.add(m);
			mMap[x].get(y).add(m);
		}
		
	}

	private static void play() {
		int turn = 0;
		Deque<Mal> deque = new ArrayDeque<>();
		
		while(++turn <= 1000) {
			for(Mal mal : mList) {
				int x = mal.x;
				int y = mal.y;

				int index = mMap[x].get(y).indexOf(mal);
				if(index != 0) continue;
				
				// 다음 땅 물색. 다음 땅이 2라면 방향 반대로 전환. 만약 반대 방향도 2라면 이동 스킵
				if(map[x + dx[mal.d]][y + dy[mal.d]] == 2) {
					if(mal.d == 1)
						mal.d = 2;
					else if(mal.d == 2) 
						mal.d = 1;
					else if(mal.d == 3)
						mal.d = 4;
					else if(mal.d == 4)
						mal.d = 3;
					
					if(map[x + dx[mal.d]][y + dy[mal.d]] == 2)
						continue;
				}
				
				
				int length = mMap[x].get(y).size();
				
				// 탑승
				for(int i = index; i < length; i++) {
					deque.addFirst(mMap[x].get(y).pollLast());
				}
				
				
				// 다음 땅 이동. 0이라면 앞부터, 1이라면 뒤부터 뽑아서 이동
				x += dx[mal.d];
				y += dy[mal.d];
				int color = map[x][y];
				
				if(color == 0) {
					while(!deque.isEmpty()) {
						Mal m = deque.pollFirst();
						m.x = x;
						m.y = y;
						mMap[x].get(y).add(m);
					}
				}
				else if(color == 1) {
					while(!deque.isEmpty()) {
						Mal m = deque.pollLast();
						m.x = x;
						m.y = y;
						mMap[x].get(y).add(m);
					}
				}
				
				// 이동 후 해당 칸 사이즈 검사. 4 이상이면 종료
				if(mMap[x].get(y).size() >= 4) {
					System.out.println(turn);
					return;
				}
				
			}
		}
		
		System.out.println(-1);
		
	}

}