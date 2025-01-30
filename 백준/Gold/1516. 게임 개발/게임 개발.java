import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] wait;
	static int[] times;
	static ArrayList<Integer>[] lists;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		wait = new int[N + 1];
		times = new int[N + 1];
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		ans = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) break;
				wait[i]++;
				lists[n].add(i);
			}
		}
		
		topologySort();
		
		for(int i = 1; i <= N; i++)
			sb.append(ans[i] + times[i]).append("\n");
		
		System.out.print(sb.toString());
	}

	private static void topologySort() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(wait[i] == 0)
				deque.add(i);
		}
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			for(int next : lists[now]) {
				ans[next] = Math.max(ans[next], ans[now] + times[now]);
				if(--wait[next] == 0)
					deque.add(next);
			}
		}
	}

}