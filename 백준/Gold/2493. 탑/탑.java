import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int index = 0;
		Deque<int[]> left = new ArrayDeque<>(N);
		Deque<int[]> right = new ArrayDeque<>(N);
		int[] ans = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			left.add(new int[] { temp, index++ });
		}

		for (int i = 0; i < N; i++) {
			int[] next = left.pollLast();

			while (!right.isEmpty() && next[0] > right.peekLast()[0]) {
				int[] temp2 = right.pollLast();
				ans[temp2[1]] = next[1] + 1;
			}
			
			right.addLast(next);

		}

		while (!right.isEmpty()) {
			int[] temp = right.pollLast();
			ans[temp[1]] = 0;
		}

		for (int x : ans) {
			sb.append(x + " ");
		}

		System.out.println(sb.toString());
	}

}