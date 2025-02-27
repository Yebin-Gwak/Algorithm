import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		st.nextToken();
		int Q = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<>();
		boolean reverse = false;
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				int v = Integer.parseInt(st.nextToken());
				if (!reverse)
					deque.addFirst(v);
				else
					deque.addLast(v);
			} else if (cmd == 1) {
				while (!deque.isEmpty())
					set.add(deque.poll());
				set.remove(-1);
				reverse = false;
				if (!set.isEmpty())
					deque.add(-1);
			} else
				reverse = !reverse;
		}

		for (int i = 0; i < K - 1; i++) {
			int v = (!reverse) ? deque.pollFirst() : deque.pollLast();
			if (v != -1)
				continue;
			v = (!reverse) ? set.first() : set.last();
			set.remove(v);
			if (!set.isEmpty()) {
				if (!reverse)
					deque.addFirst(-1);
				else
					deque.addLast(-1);
			}
		}
		
		int v = (!reverse) ? deque.pollFirst() : deque.pollLast();
		if(v == -1)
			v = (!reverse) ? set.first() : set.last();

		System.out.print(v);

	}

}