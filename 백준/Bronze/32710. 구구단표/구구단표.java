import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[101];
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++)
				check[i * j] = true;
		}
		
		System.out.println(check[N] ? 1 : 0);
	}
}