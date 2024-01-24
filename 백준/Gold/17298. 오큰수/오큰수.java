import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int len = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<Integer> prev = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		int[] ans = new int[len];
		int idx = 0;

		for (int i = 0; i < len; i++) {
			int next = Integer.parseInt(st.nextToken());

			while (!prev.isEmpty() && next > prev.peek()) {
				ans[index.pop()] = next;
				prev.pop();
			}

			prev.push(next);
			index.push(idx++);
		}

		while (!index.isEmpty())
			ans[index.pop()] = -1;

		for (int value : ans)
			sb.append(value + " ");

		System.out.println(sb.toString());
	}

}