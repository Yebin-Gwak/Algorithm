import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BigInteger[] fibo = new BigInteger[491];
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		for(int i = 2; i < 491; i++)
			fibo[i] = fibo[i - 1].add(fibo[i - 2]);
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1)
				break;
			sb.append("Hour " + n + ": " + fibo[n] + " cow(s) affected\n");
		}
		System.out.println(sb);
	}
}