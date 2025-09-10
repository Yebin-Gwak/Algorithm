import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int c0 = Integer.parseInt(st.nextToken());
		int d0 = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int max = a / b;
			int min = 1;
			while(c * min <= N && max != 0) {
			for(int j = N; j >= c * min; j--)
				dp[j] = Math.max(dp[j], dp[j - c] + d);
			min++;
			max--;
			}
		}
		
		int min = 1;
		while(c0 * min <= N) {
			for(int j = N; j >= c0 * min; j--)
				dp[j] = Math.max(dp[j], dp[j - c0] + d0);
			min++;
		}
		
		System.out.println(dp[N]);
		
	}
}