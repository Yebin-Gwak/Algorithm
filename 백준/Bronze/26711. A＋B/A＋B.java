import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(new BigInteger(br.readLine()).add(new BigInteger(br.readLine())));
	}

}