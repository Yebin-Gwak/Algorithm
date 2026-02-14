import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			sb.append(c[0]);
			for(int j = 1; j < c.length; j++) {
				if(c[j] == c[j - 1])
					continue;
				sb.append(c[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}