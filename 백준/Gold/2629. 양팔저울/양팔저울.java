import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] items = new int[N];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			sum += items[i];
		}
		
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for(int w : items) {
			for(int i = sum; i >= w; i--) {
				if(dp[i])
					continue;
				
				if(dp[i - w])
					dp[i] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w : for(int i = 0; i < M; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(v > sum) {
				sb.append("N ");
				continue;
			}
			
			if(dp[v]) {
				sb.append("Y ");
				continue;
			}
			
			for(int j = 1; j <= sum - v; j++) {
				if(dp[j] && dp[j + v]) {
					sb.append("Y ");
					continue w;
				}
			}
			
			sb.append("N ");
			
			
		}
		
		System.out.println(sb.toString());
		
	}

}