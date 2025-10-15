import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(br.readLine());
			System.out.print(v + " is " );
			System.out.println((v % 2 == 0) ? "even" : "odd");
		}
	}
}