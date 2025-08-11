import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> wait = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			wait.add(new int[] {d, w});
		}

		int M = wait.peek()[0];

		int ans = 0;
		for (int i = M; i >= 1; i--) {
			while (!wait.isEmpty()) {
				if (wait.peek()[0] == i)
					pq.add(wait.poll());
				else
					break;
			}
			if(!pq.isEmpty())
				ans += pq.poll()[1];
		}
		
		System.out.println(ans);

	}
}