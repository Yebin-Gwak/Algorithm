import java.util.*;
import java.io.*;

public class Main {
	static int T, N, K, W;
	static int[] wait;
	static int[] times;
	static ArrayList<Integer>[] lists;
	static int[] ans;
	static ArrayDeque<Integer> deque = new ArrayDeque<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			wait = new int[N + 1];
			times = new int[N + 1];
			lists = new ArrayList[N + 1];
			for(int i = 0; i <= N; i++)
				lists[i] = new ArrayList<>();
			ans = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++)
				times[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				lists[before].add(after);
				wait[after]++;
			}
			W = Integer.parseInt(br.readLine());
			
			topologySort();
			sb.append(ans[W] + "\n");
			
		}
		
		System.out.print(sb.toString());
	}


	private static void topologySort() {
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
		for(int i = 1; i <= N; i++)
			ans[i] += times[i];
	} 

}