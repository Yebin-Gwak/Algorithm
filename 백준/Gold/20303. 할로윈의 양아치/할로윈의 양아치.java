import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[][] dp;
	static int[] counts;
	static int[] candies;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		make();
		counts = new int[N + 1];
		Arrays.fill(counts, 1);
		candies = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			candies[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		dp = new int[N + 1][K];
		

		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j < K; j++) {
				if(counts[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - counts[i]] + candies[i]);
				}
			}
		}
		
		int ans = 0;
		for(int x : dp[N])
			ans = Math.max(ans, x);
		System.out.println(ans);
		
	}

	private static void make() {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parents[i] = i;
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return;
		parents[bRoot] = parents[aRoot];
		counts[aRoot] += counts[bRoot];
		candies[aRoot] += candies[bRoot];
		counts[bRoot] = 0;
		candies[bRoot] = 0;
		return;
	}
}
