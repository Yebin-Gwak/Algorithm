import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();

			String cmd = br.readLine();
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[,]");

			Deque<String> arr = new ArrayDeque<String>(num);
			boolean reverse = false;
			boolean error = false;

			for (int i = 0; i < num; i++)
				arr.add(st.nextToken());

			for (int j = 0; j < cmd.length(); j++) {
				char c = cmd.charAt(j);

				if (c == 'R')
					reverse = !reverse;
				else {
					if (arr.isEmpty()) {
						error = true;
						break;
					} else {
						if (!reverse)
							arr.poll();
						else
							arr.pollLast();
					}
				}

			}

			if (error)
				sb.append("error");
			else {
				sb.append("[");

				if (reverse) {
					while (!arr.isEmpty()) {
						sb.append(arr.pollLast());
						if (!arr.isEmpty())
							sb.append(",");
					}

				} else {
					while (!arr.isEmpty()) {
						sb.append(arr.poll());
						if (!arr.isEmpty())
							sb.append(",");
					}
				}

				sb.append("]");
			}

			System.out.println(sb.toString());

		}

	}

}