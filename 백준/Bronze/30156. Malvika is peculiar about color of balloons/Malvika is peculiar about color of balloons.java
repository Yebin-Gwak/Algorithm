import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int a = 0;
			int b = 0;
			for(char c : s.toCharArray())
				if(c == 'a')
					a++;
				else
					b++;
			sb.append(Math.min(a, b) + "\n");
		}
		System.out.println(sb);
	}
}