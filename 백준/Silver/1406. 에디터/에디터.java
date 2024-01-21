import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> arr = new LinkedList<>();

		String str = br.readLine();
		ListIterator<Character> iter = arr.listIterator();

		for (int i = 0; i < str.length(); i++) {
			iter.add(str.charAt(i));
		}

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);

			switch (c) {
			case 'L':
				if (iter.hasPrevious())
					iter.previous();
				break;

			case 'D':
				if (iter.hasNext())
					iter.next();
				break;

			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;

			case 'P':
				iter.add(cmd.charAt(2));
				break;
			}

		}
		for (char c : arr)
			sb.append(c);
		System.out.println(sb);

	}
}