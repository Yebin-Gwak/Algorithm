import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		long[][][]dp = new long[N][N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i++) {
			if(map[0][i] == 1) break;
			dp[0][i][0] = 1;
		}
		
		// 가로, 세로, 대각선 모양으로 올 수 있는 경우의 수
		for(int i = 1; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] == 1) continue;
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				if(map[i][j - 1] == 1 || map[i - 1][j] == 1) continue;
				dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);

	}

}