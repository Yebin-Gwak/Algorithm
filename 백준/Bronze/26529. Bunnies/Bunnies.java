import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] fibo = new long[47];
		fibo[1] = 1;
		for(int i = 2; i < 47; i++)
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++)
			System.out.println(fibo[Integer.parseInt(br.readLine()) + 1]);
	}
}