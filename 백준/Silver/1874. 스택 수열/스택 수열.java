import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.add(0);
		int next = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			while (n > next) {
				deque.addLast(++next);
				sb.append("+" + "\n");
			}

			if (deque.peekLast() != n) {
				System.out.println("NO");
				return;
			}
			
			deque.pollLast();
			sb.append("-" + "\n");
		}
		
		System.out.print(sb.toString());
	}

}