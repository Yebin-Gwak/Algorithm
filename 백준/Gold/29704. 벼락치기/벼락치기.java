import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N];
		int[] values = new int[N];
		int max = 0;
		int[] dp = new int[T + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
			max += values[i];
		}
		
		Arrays.fill(dp, max);
		
		for(int i = 0; i < N; i++) {
			int w = weights[i];
			int v = values[i];
			for(int j = T; j >= w; j--) {
				dp[j] = Math.min(dp[j], dp[j - w] - v);
			}
		}
		
		System.out.println(dp[T]);
		
	}

}