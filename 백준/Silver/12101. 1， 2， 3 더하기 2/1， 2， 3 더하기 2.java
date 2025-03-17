import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<String>[] dp = new ArrayList[N + 3];
		for(int i = 0; i <= N + 2; i++)
			dp[i] = new ArrayList<>();
		
		dp[1].add("1");
		dp[2].add("1+1");
		dp[2].add("2");
		dp[3].add("1+1+1");
		dp[3].add("1+2");
		dp[3].add("2+1");
		dp[3].add("3");
		
		for(int i = 4; i <= N; i++) {
			for(int j = 1; j <= 3; j++) {
				for(String s : dp[i - j])
					dp[i].add(s + "+" + j);
			}
		}
		
		if(dp[N].size() < K) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(dp[N]);
		System.out.println(dp[N].get(K - 1));
		
	}

}