import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		dp[1] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N - 1; i++) {
			int value = Integer.parseInt(st.nextToken());
			find2(value);
		}
		
		if(dp[N] != 0)
			System.out.println(N);
		else
			System.out.println(ans());
	}
	
	private static int ans() {
		int left = 0;
		int right = N;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if(dp[mid] == 0) {
				if(dp[mid - 1] != 0)
					return mid - 1;
				right = mid - 1;
			}
			else if(dp[mid] != 0) {
				if(dp[mid + 1] == 0)
					return mid;
				left = mid + 1;
			}
		}
		return 1;
		
	}
	
	private static void find2(int num) {
		int left = 0;
		int right = N;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if(mid == 0) {
				if(dp[1] > num)
					dp[1] = num;
				return;
			}
			if(dp[mid] == 0) {
				if(dp[mid - 1] == 0 || dp[mid - 1] > num)
					right = mid;
				else if(dp[mid - 1] < num) {
					dp[mid] = num;
					return;
				}
				else
					return;
			}
			
			else if (dp[mid] < num) {
				if(dp[mid + 1] > num || dp[mid + 1] == 0) {
					dp[mid + 1] = num;
					return;
				}
				else if(dp[mid + 1] < num) {
					left = mid + 1;
				}
				else
					return;
			}
				
			else if (dp[mid] > num) {
				if(dp[mid - 1] < num) {
					dp[mid] = num;
					return;
				}
				right = mid - 1;
			}

			else return;
		}
		return;
		
	}

}