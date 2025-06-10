import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int[] coins = new int[4];
		int[] values = new int[] {1, 5, 10, 25};
		int[][] uses = new int[X + 1][4];
		for (int i = 0; i < 4; i++)
			coins[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[X + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 0; i < 4; i++) {
			int c = coins[i];
			int v = values[i];

			int k = 1;
			while (c > 0) {
				int use = Math.min(k, c);
				int w = v * use;

				for (int j = X - w; j >= 0; j--) {
					if (dp[j] == -1)
						continue;

					if (dp[j + w] < dp[j] + use) {
						dp[j + w] = dp[j] + use;
						uses[j + w] = uses[j].clone();
						uses[j + w][i] += use;
					}

				}

				c -= use;
				k *= 2;
			}
		}

		if (dp[X] == -1) {
			System.out.println("0 0 0 0");
			return;
		}
		
		System.out.println(uses[X][0] + " " + uses[X][1] + " " + uses[X][2] + " " + uses[X][3]);

	}
}
