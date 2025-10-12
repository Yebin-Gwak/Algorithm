import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= N; tc++) {
			int M = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++)
				M = Math.max(M, Integer.parseInt(st.nextToken()));
			
			sb.append("Case #" + tc + ": " + M + "\n");
		}
		
		System.out.print(sb);
		
	}
}