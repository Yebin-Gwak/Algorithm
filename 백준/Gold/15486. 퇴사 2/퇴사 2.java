import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2];
		
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i]);
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			if(i + day > N + 1)
				continue;
			dp[i + day] = Math.max(dp[i + day], dp[i] + pay);
		}
		
		dp[N + 1] = Math.max(dp[N + 1], dp[N]);
		System.out.println(dp[N + 1]);
	}

}