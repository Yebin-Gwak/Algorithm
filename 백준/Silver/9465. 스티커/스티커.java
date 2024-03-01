import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N + 1][2];
			dp = new int[N + 1][2];
			
			for(int i = 1; i >= 0; i--) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][0] = arr[1][0];
			dp[1][1] = arr[1][1];
			
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j < 2; j++) {
					dp[i][j] = Math.max(Math.max(dp[i - 2][j], dp[i - 2][Math.abs(1 - j)]), dp[i - 1][Math.abs(1 - j)]) + arr[i][j];
				}
			}
			
			sb.append(Math.max(dp[N][0], dp[N][1]) + "\n");
		}
		System.out.print(sb.toString());
		
	}

}