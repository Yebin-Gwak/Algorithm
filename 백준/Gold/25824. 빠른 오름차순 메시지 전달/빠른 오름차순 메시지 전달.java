import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr = new int[12][12];
	static boolean[] visited = new boolean[12];
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 12; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		visited[0] = true;
		dfs(0, 0, 1);
		visited[0] = false;
		visited[1] = true;
		dfs(1, 0, 1);

		System.out.println(answer);

	}

	private static void dfs(int n, int sum, int count) {

		if (count == 12) {
			answer = Math.min(answer, sum);
			return;
		}
		if (n == 10) {
			dfs(11, sum + arr[n][11], count + 1);
			return;
		}
		if (n == 11) {
			dfs(10, sum + arr[n][10], count + 1);
			return;
		}

		if (n % 2 == 0) {
			if (visited[n + 1]) {
				visited[n + 2] = true;
				dfs(n + 2, sum + arr[n][n + 2], count + 1);
				visited[n + 2] = false;

				visited[n + 3] = true;
				dfs(n + 3, sum + arr[n][n + 3], count + 1);
				visited[n + 3] = false;
			} else {
				visited[n + 1] = true;
				dfs(n + 1, sum + arr[n][n + 1], count + 1);
				visited[n + 1] = false;
			}
		} else {
			if (!visited[n - 1]) {
				visited[n - 1] = true;
				dfs(n - 1, sum + arr[n][n - 1], count + 1);
				visited[n - 1] = false;
			} else {
				visited[n + 1] = true;
				dfs(n + 1, sum + arr[n][n + 1], count + 1);
				visited[n + 1] = false;

				visited[n + 2] = true;
				dfs(n + 2, sum + arr[n][n + 2], count + 1);
				visited[n + 2] = false;
			}
		}

	}

}