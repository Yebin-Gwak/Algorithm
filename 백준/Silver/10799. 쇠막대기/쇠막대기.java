import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cmd = br.readLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		int ans = 0;
		char pre = ' ';

		for (int i = 0; i < cmd.length(); i++) {
			char c = cmd.charAt(i);
			if (c == '(') {
				stack.addLast(c);
			} else {
				if (pre == '(') {
					stack.pollLast();
					ans += stack.size();
				} else {
					stack.pollLast();
					ans++;
				}
			}
			pre = c;
		}

		System.out.println(ans);

	}
}