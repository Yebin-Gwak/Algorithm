import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[101];
		int[][] items = new int[N][2];
		
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				items[j][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 100; j > items[i][0]; j--)
				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
		}
		
		System.out.println(dp[100]);
		
	}

}