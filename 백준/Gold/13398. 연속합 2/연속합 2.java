import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][2];
		st = new StringTokenizer(br.readLine());
		
		dp[0][0] = Integer.parseInt(st.nextToken());
		int max = dp[0][0];
		for(int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.max(dp[i - 1][0] + n, n);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + n);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
		
	}

}