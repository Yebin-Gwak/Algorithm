import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] lists;
	static int[] wait;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		wait = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[a].add(b);
			wait[b]++;
		}
		
		topologySort();
		
		System.out.println(sb.toString());
		
	}
	
	private static void topologySort() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(wait[i] == 0)
				deque.add(i);
		}
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			sb.append(now + " ");
			for(int next : lists[now]) {
				if(--wait[next] == 0)
					deque.add(next);
			}
		}
	}
}