import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				coins[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M + 1];
			dp[0] = 1;
			
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= M; j++) {
					if(j - coins[i] < 0)
						continue;
					dp[j] += dp[j - coins[i]];
				}
			}
			sb.append(dp[M] + "\n");
		}
		System.out.print(sb.toString());
	}

}