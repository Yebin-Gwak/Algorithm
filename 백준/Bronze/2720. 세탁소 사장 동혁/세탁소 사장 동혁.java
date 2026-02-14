import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(br.readLine());
			sb.append(v / 25 + " ");
			v -= (v / 25) * 25;
			sb.append(v / 10 + " ");
			v -= (v / 10) * 10;
			sb.append(v / 5 + " ");
			v -= (v / 5) * 5;
			sb.append(v / 1 + "\n");
		}
		System.out.println(sb);
	}
}