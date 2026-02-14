import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println("1");
			System.exit(0);
		}
		else if(N == 1) {
			System.out.println("0");
			System.exit(0);
		}
		sb.append("4".repeat(N % 2));
		sb.append("8".repeat(N / 2));
		System.out.println(sb); 
	}
}