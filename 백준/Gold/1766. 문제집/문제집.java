import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] wait;
	static ArrayList<Integer>[] lists;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		wait = new int[N + 1];
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			lists[before].add(after);
			wait[after]++;
		}
		
		topologySort();
		
		System.out.print(sb.toString().trim());
	}

	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(wait[i] == 0)
				pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			for(int next : lists[now]) {
				if(--wait[next] == 0)
					pq.add(next);
			}
		}
	}
}