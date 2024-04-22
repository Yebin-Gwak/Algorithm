import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp1 = new int[N + 1][3];
		int[][] dp2 = new int[N + 1][3];
		int[][] dp3 = new int[N + 1][3];
		
		dp1[1][0] = arr[1][0];
		dp1[1][1] = 20000000;
		dp1[1][2] = 20000000;
		
		dp2[1][0] = 20000000;
		dp2[1][1] = arr[1][1];
		dp2[1][2] = 20000000;
		
		dp3[1][0] = 20000000;
		dp3[1][1] = 20000000;
		dp3[1][2] = arr[1][2];
		
		for(int i = 2; i <= N; i++) {
			dp1[i][0] = Math.min(dp1[i - 1][1], dp1[i - 1][2]) + arr[i][0];
			dp2[i][0] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + arr[i][0];
			dp3[i][0] = Math.min(dp3[i - 1][1], dp3[i - 1][2]) + arr[i][0];
			
			dp1[i][1] = Math.min(dp1[i - 1][0], dp1[i - 1][2]) + arr[i][1];
			dp2[i][1] = Math.min(dp2[i - 1][0], dp2[i - 1][2]) + arr[i][1];
			dp3[i][1] = Math.min(dp3[i - 1][0], dp3[i - 1][2]) + arr[i][1];
			
			dp1[i][2] = Math.min(dp1[i - 1][0], dp1[i - 1][1]) + arr[i][2];
			dp2[i][2] = Math.min(dp2[i - 1][0], dp2[i - 1][1]) + arr[i][2];
			dp3[i][2] = Math.min(dp3[i - 1][0], dp3[i - 1][1]) + arr[i][2];
			
		}
		dp1[N][0] = Integer.MAX_VALUE;
		dp2[N][1] = Integer.MAX_VALUE;
		dp3[N][2] = Integer.MAX_VALUE;
		
		int ans = Integer.MAX_VALUE;
		for(int x : dp1[N])
			ans = Math.min(ans, x);
		for(int x : dp2[N])
			ans = Math.min(ans, x);
		for(int x : dp3[N])
			ans = Math.min(ans, x);
		
		
		System.out.println(ans);
		
	}

}