import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		TreeSet<Integer> coins = new TreeSet<>();
		
		int[]dp = new int[K + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			if(c <= K) {
				coins.add(c);
				dp[c] = 1;
			}
		}
		
		for(int c : coins) {
			for(int i = c; i <= K - c; i++) {
				if(dp[i] != Integer.MAX_VALUE)
					dp[i + c] = Math.min(dp[i + c], dp[i] + 1);
			}
		}
		
		System.out.println((dp[K] == Integer.MAX_VALUE) ? -1 : dp[K]);
	}
}
