import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[M + 1];
		prime[1] = true;
		for(int i = 2; i <= M; i++) {
			if(prime[i]) continue;
			for(int j = i * 2; j <= M; j += i)
				prime[j] = true;
		}
		
		for(int i = N; i <= M; i++) {
			if(!prime[i])
				sb.append(i + "\n");
		}
		System.out.print(sb.toString());
	}
}