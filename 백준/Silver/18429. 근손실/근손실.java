import java.util.*;
import java.io.*;

public class Main {
	static int[] training;
	static boolean[] visited;
	static int N, K;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		training = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			training[i] = Integer.parseInt(st.nextToken());

		dfs(500, 0);

		System.out.println(ans);

	}

	private static void dfs(int weight, int cnt) {
		if (weight < 500)
			return;

		if (cnt == N)
			ans++;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(weight - K + training[i], cnt + 1);
				visited[i] = false;
			}
		}

	}

}