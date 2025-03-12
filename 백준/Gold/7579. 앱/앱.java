import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] apps = new int[N][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				apps[j][i] = Integer.parseInt(st.nextToken());
		}
		
		int maxC = 0;
		for(int[] n : apps)
			maxC += n[1];

		int[] dp = new int[maxC + 1];
		for (int i = 0; i < N; i++) {
			for (int j = maxC; j >= apps[i][1]; j--)
				dp[j] = Math.max(dp[j], dp[j - apps[i][1]] + apps[i][0]);
		}

		for (int i = 0; i <= maxC; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				return;
			}
		}

	}
}