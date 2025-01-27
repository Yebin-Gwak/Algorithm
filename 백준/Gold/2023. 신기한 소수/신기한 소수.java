import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs(0, 0);
		System.out.print(sb.toString());
	}

	private static void dfs(int cnt, int num) {
		if (cnt == N) {
			if (check(num)) 
				sb.append(num + "\n");
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (check(num * 10 + i)) {
				dfs(cnt + 1, num * 10 + i);
			}
		}

	}

	private static boolean check(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
