import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			String n = br.readLine();
			String s = br.readLine();
			sb.append("Case " + i + ": " + s + ", " + n + "\n");
		}
		System.out.print(sb.toString().trim());
		
	}
}