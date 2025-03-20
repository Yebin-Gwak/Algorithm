import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
			
			if(N == 0 && M == 0.00)
				break;
			
			int[] w = new int[N];
			int[] v = new int[N];
			int[] dp = new int[M + 1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				w[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = w[i]; j <= M; j++)
					dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
			
			sb.append(dp[M] + "\n");
		}
		
		System.out.print(sb.toString());
	}

}