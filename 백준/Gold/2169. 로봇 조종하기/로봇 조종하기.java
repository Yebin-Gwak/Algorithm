import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		int[] leftStart = new int[M];
		int[] rightStart = new int[M];
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		for(int i = 1; i < M; i++)
			dp[0][i] = dp[0][i - 1] + map[0][i];
		
		for(int i = 1; i < N; i++) {
			leftStart[0] = dp[i - 1][0] + map[i][0];
			rightStart[M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
			for(int j = 1; j < M; j++)
				leftStart[j] = Math.max(leftStart[j - 1], dp[i - 1][j]) + map[i][j];
			
			for(int j = M - 2; j >= 0; j--)
				rightStart[j] = Math.max(rightStart[j + 1], dp[i - 1][j]) + map[i][j];
			
			for(int j = 0; j < M; j++)
				dp[i][j] = Math.max(leftStart[j], rightStart[j]);
		}
		
		System.out.println(dp[N - 1][M - 1]);
		
	}

}