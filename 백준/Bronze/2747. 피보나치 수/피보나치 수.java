import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] fibo = new long[46];
		fibo[1] = 1;
		for(int i = 2; i < 46; i++)
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		System.out.println(fibo[Integer.parseInt(br.readLine())]);
	}
}