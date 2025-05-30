import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int INF = 10000000;
		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				Arrays.fill(dp[i][j], INF);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			dp[0][i][0] = dp[0][i][1] = dp[0][i][2] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if(j != 0)
					dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + n;
				dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + n;
				if(j != M - 1)
					dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + n;
			}
		}
		
		int min = INF;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < 3; j++) {
				min = Math.min(min, dp[N - 1][i][j]);
			}
		}
		System.out.println(min);

	}
}
