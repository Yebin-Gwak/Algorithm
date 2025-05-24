import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		BigInteger extra = new BigInteger(br.readLine());
		N = (N.subtract(extra)).divide(BigInteger.TWO);
		System.out.println(N.add(extra));
		System.out.println(N);
		
	}

}