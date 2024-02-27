import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][j] + map[i][j];
					continue;
				}
				if(j == i) {
					dp[i][j] = dp[i - 1][j - 1] + map[i][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j- 1], dp[i - 1][j]) + map[i][j];
			}
		}
		
		int ans = 0;
		for(int x : dp[N - 1]) {
			ans = Math.max(ans, x);
		}
		
		System.out.println(ans);
		
	}

}
