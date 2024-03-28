import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) 
			Arrays.fill(dp[i], 1000000001);

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[a][b] = Math.min(dp[a][b], c);
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(i == k) continue;
				for(int j = 1; j <= N; j++) {
					if(j == i || j == k) continue;
					dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dp[i][j] == 1000000001)
					dp[i][j] = 0;
				sb.append(dp[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}