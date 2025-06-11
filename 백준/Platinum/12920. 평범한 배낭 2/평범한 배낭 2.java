import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dp = new int[M + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int b = 1;
			while(K > 0) {
				int use = Math.min(b, K);
				int w = V * use;
				int v = C * use;
				
				for(int j = M; j >= w; j--)
					dp[j] = Math.max(dp[j], dp[j - w] + v);
				
				K -= use;
				b *= 2;
			}
			
		}
		
		System.out.println(dp[M]);
		
	}
}