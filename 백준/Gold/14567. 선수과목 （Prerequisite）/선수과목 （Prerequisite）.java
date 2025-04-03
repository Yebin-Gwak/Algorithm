import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] wait;
	static List<Integer>[] lists;
	static int[] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		wait = new int[N + 1];
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		ans = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			wait[after]++;
			lists[before].add(after);
		}
		
		topologySort();
		
		for(int i = 1; i <= N; i++)
			sb.append(ans[i] + " ");
		System.out.print(sb.toString().trim());
		
	}

	private static void topologySort() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(wait[i] == 0)
				deque.add(i);
		}
		
		int term = 1;
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				int now = deque.poll();
				ans[now] = term;
				
				for(int next : lists[now]) {
					if(--wait[next] == 0)
						deque.add(next);
				}
			}
			term++;
		}
		
	}

}