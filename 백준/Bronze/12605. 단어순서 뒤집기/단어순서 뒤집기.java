import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<String> stk = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				stk.add(st.nextToken());
			sb.append("Case #" + i + ": ");
			while(stk.size() != 1)
				sb.append(stk.pollLast() + " ");
			sb.append(stk.poll());
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}