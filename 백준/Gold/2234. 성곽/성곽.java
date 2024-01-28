import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] map, field;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		map = new int[M][N]; // 입력값 저장용 배열
		field = new int[M][N]; // map을 해석, 각 방 번호로 변환하여 저장하는 배열

		int count = 0; // 방 개수
		int maxRoomSize = 0; // 가장 큰 방의 크기
		int[] roomSizes = new int[2501]; // 각 방의 크기를 담는 배열

		int maxSizeSum = 0; // 부수고 합쳤을 때 가장 큰 값

		for (int i = 0; i < M; i++) { // 입력값 map에 저장
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) { // bfs로 각 방 번호 매김 + 해당 방의 크기 리턴
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count++;
					int size = bfs(i, j, count);
					roomSizes[count] = size;
					if (size > maxRoomSize)
						maxRoomSize = size;
				}

			}
		}

		ArrayList<ArrayList<Integer>> link = new ArrayList<>(); // 서로 인접한 방 리스트
		link.add(new ArrayList<Integer>()); // 0번 인덱스

		for (int a = 1; a <= count; a++) {
			ArrayList<Integer> tempArr = new ArrayList<>();
			boolean[] check = new boolean[count + 1];
			check[a] = true;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (field[i][j] != a)
						continue;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && !check[field[nx][ny]] && a < field[nx][ny]) {
							check[field[nx][ny]] = true;
							tempArr.add(field[nx][ny]);
						}
					}
				}

			}
			link.add(tempArr);
		}

		for (int i = 1; i < link.size(); i++) {
			for (int j = 0; j < link.get(i).size(); j++) {
				int tempSum = roomSizes[i] + roomSizes[link.get(i).get(j)];
				if(tempSum > maxSizeSum)
					maxSizeSum = tempSum;
			}
		}

		System.out.println(count);
		System.out.println(maxRoomSize);
		System.out.println(maxSizeSum);

	}

	private static int bfs(int startX, int startY, int count) {
		Deque<int[]> deque = new ArrayDeque<>();
		visited[startX][startY] = true;
		deque.addLast(new int[] { startX, startY });
		int size = 1;

		while (!deque.isEmpty()) {
			int[] temp = deque.pollFirst();
			int x = temp[0];
			int y = temp[1];
			field[x][y] = count;
			String wall = String.format("%04d", Integer.parseInt(Integer.toBinaryString(map[x][y]))); //map의 정수값을 4자리 2진수로 변환

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (wall.charAt(i) == '0' && (0 <= nx && nx < M) && (0 <= ny && ny < N)) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						deque.add(new int[] { nx, ny });
						size++;
					}
				}

			}
		}
		return size;

	}

}