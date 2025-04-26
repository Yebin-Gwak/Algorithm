import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t : for(int tc = 0; tc < 3; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] coins = new int[N][2];
			int sum = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				coins[i][0] = Integer.parseInt(st.nextToken());
				coins[i][1] = Integer.parseInt(st.nextToken());
				sum += coins[i][0] * coins[i][1];
			}
			
			if(sum % 2 != 0) {
				System.out.println(0);
				continue;
			}
			
			int half = sum / 2;
			
			boolean[] dp = new boolean[half + 1];
			dp[0] = true;
			
			for(int i = 0; i < N; i++) {
				int coin = coins[i][0];	
				for(int j = sum / 2; j >= coin; j--) {
					if(dp[j])
						continue;
					for(int k = 1; k <= coins[i][1]; k++) {
						if(j - coin * k < 0)
							break;
						if(dp[j - (coin * k)]) {
							dp[j] = true;
							break;
						}
					}
				}
				
				if(dp[half]) {
					System.out.println(1);
					continue t;
				}
			}
			
			System.out.println(0);
			
		}
		
		
	}

}