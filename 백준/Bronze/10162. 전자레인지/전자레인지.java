import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		if(N % 10 != 0) {
			System.out.println(-1);
			System.exit(0);
		}
		sb.append(N / 300 + " ");
		N = N % 300;
		sb.append(N / 60 + " ");
		N = N % 60;
		sb.append(N / 10);
		N = N % 10;
		System.out.println(sb);
	}
}