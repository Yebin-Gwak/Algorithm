import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int MAX = 1000000;
		int DIV = 1000000009;
		long[] dp = new long[MAX + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= MAX; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % DIV;
		
		for(int i = 0; i < T; i++)
			sb.append(dp[Integer.parseInt(br.readLine())] + "\n");
		System.out.print(sb.toString());
		
	}

}