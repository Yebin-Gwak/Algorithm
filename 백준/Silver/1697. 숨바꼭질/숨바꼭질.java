import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] map;
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[100001];
		visited = new boolean[100001];
		bfs();

		System.out.println(ans);
	}

	private static void bfs() {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.add(N);
		visited[N] = true;

		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int k = 0; k < size; k++) {
				int now = deque.poll();

				if (now == K)
					return;

				if (now * 2 <= 100000 && !visited[now * 2]) {
					visited[now * 2] = true;
					deque.add(now * 2);
				}
				if (now + 1 <= 100000 && !visited[now + 1]) {
					visited[now + 1] = true;
					deque.add(now + 1);
				}
				if (now - 1 >= 0 && !visited[now - 1]) {
					visited[now - 1] = true;
					deque.add(now - 1);
				}

			}

			ans++;
		}

	}

}