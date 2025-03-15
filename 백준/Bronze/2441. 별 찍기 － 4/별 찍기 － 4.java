import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++)
			sb.append(" ".repeat(i) + "*".repeat(N - i) +"\n");

		System.out.print(sb.toString());
	}

}