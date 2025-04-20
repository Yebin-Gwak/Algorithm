import java.io.*;

public class Main {

	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[1000];
		dp[0] = 3;
		dp[1] = 10;
		if(N <= 10) {
			System.out.println("moomooomoo".charAt(N - 1));
			return;
		}
		int idx = 2;
		for(int i = 2; i < 1000; i++) {
			dp[i] = dp[i - 1] + 1 + (i + 2) + dp[i - 1];
			if(dp[i] >= N) {
				idx = i;
				break;
			}
		}
		
		find(idx, N);
		
	}

	private static void find(int idx, int v) {
		if(idx <= 1) {
			System.out.println("moomooomoo".charAt(v - 1));
			return;
		}
		
		if(v <= dp[idx - 1])
			find(idx - 1, v);
		else if(v > dp[idx - 1] + 1 + (idx + 2))
			find(idx - 1, v - (dp[idx - 1] + 1 + (idx + 2)));
		else if(v == dp[idx - 1] + 1 || v == dp[idx] - dp[idx - 1] + 1)
			System.out.println("m");
		else 
			System.out.println("o");
		
	}

}