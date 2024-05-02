import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case 1:
				stack.add(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.pollLast() + "\n");
				break;
			case 3:
				sb.append(stack.size() + "\n");
				break;
			case 4:
				if (stack.isEmpty())
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
				break;
			case 5:
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.peekLast() + "\n");
				break;
			}

		}
		System.out.print(sb.toString());
	}
}