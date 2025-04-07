import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());
		
		dp[0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + n, n);
		}
		
		int max = dp[0];
		for(int i = 1; i < N; i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
		
	}

}