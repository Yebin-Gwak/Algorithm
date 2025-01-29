import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, "+-");
		ArrayDeque<Integer> op = new ArrayDeque<>();
		ArrayDeque<Integer> nums = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '+' || c == '-')
				op.add((c == '+') ? 1 : -1);
		}

		while (st.hasMoreTokens())
			nums.add(Integer.parseInt(st.nextToken()));

		int ans = nums.poll();

		while (!op.isEmpty()) {
			int v = nums.poll();
			int oper = op.poll();

			while (!op.isEmpty() && op.peek() == 1) {
				op.poll();
				v += nums.poll();
			}
			ans += v * oper;
		}
		
		System.out.println(ans);
	}
}