import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] dmgs = new long[N];
		for(int i = 0; i < N; i++)
			dmgs[i] = Long.parseLong(br.readLine());
		Arrays.sort(dmgs);
		long[][] dp = new long[M][901];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			long p = Long.parseLong(st.nextToken());
			long q = Long.parseLong(st.nextToken());
			
			for(int j = 0; j < M; j++) {
				long d = dmgs[N - 1 - j];
				long w = (p / d) + ((p % d != 0) ? 1 : 0);
				if(w > 900)
					continue;
				for(int k = 900; k >= w; k--)
					dp[j][k] = Math.max(dp[j][k], dp[j][(int) (k - w)] + q);
			}
			
		}
		
		long sum = 0;
		for(int i = 0; i < M; i++)
			sum += dp[i][900];
		
		System.out.println(sum);
		
	}

}