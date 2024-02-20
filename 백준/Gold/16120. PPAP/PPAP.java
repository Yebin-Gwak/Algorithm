import java.io.*;
import java.util.*;

public class Main {
	static Deque<Character> input = new ArrayDeque<>();
	static Deque<Character> stack = new ArrayDeque<>();
	static String PPAP = "PPAP";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		if (data.equals("P")) {
			System.out.println("PPAP");
			return;
		}

		for (int i = 0; i < data.length(); i++)
			input.add(data.charAt(i));

		for (int i = 0; i < data.length() - 1; i++) {
			stack.add(input.poll());
			if (stack.peekLast() == 'A') {
				if (stack.size() >= 3 && input.peekFirst() == 'P') {
					stack.pollLast();
					stack.pollLast();
					stack.pollLast();
					stack.add(input.pollFirst());
					i++;
					continue;
				}
				System.out.println("NP");
				return;

			}
		}

		if (!input.isEmpty())
			stack.add(input.poll());

		if (stack.size() == 1 && stack.peekFirst() == 'P') {
			System.out.println("PPAP");
			return;
		} else
			System.out.println("NP");

	}
}