import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		
		int MOD = 1000000007;
		int[][] arr = new int[N][2];
		
		if(s.charAt(0) == 'W') arr[0][0] = 1;
		if(s.charAt(0) == 'E') arr[0][1] = 1;
		for(int i = 1; i < N; i++) {
			arr[i][0] = arr[i - 1][0];
			arr[i][1] = arr[i - 1][1];
			
			char c = s.charAt(i);
			if(c == 'W')
				arr[i][0]++;
			else if(c == 'E')
				arr[i][1]++;
		}
		
		long ans = 0;
		BigInteger two = BigInteger.valueOf(2);
		BigInteger mod = BigInteger.valueOf(MOD);
		
		for(int i = 0; i < N; i++) {
			if(s.charAt(i) != 'H')
				continue;
			int e = arr[N - 1][1] - arr[i][1];
			if(e < 2)
				continue;
			int result = BigInteger.valueOf(arr[i][0]).
					multiply(two.modPow(BigInteger.valueOf(e), mod)
					.subtract(BigInteger.valueOf(e + 1)).
					mod(mod))
					.mod(mod).intValue();
			ans += result;
			ans %= MOD;
		}

		System.out.println(ans);
	}

}
