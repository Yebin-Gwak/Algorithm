import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args){
		int N = new Scanner(System.in).nextInt();

		BigInteger[] dp = new BigInteger[N + 3];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		System.out.println(dp[N]);
	}
}