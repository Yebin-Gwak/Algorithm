import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node>{
		int dest;
		long cost;
		
		public Node(int dest, long cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.cost == o.cost)
				return o.dest - this.dest;
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	static int N, M, K;
	static List<Node>[] lists;
	static long[] distances;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		distances = new long[N + 1];
		Arrays.fill(distances, Long.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 역방향 간선
			lists[to].add(new Node(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			distances[n] = 0;
			pq.add(new Node(n, 0));
		}
		
		dijkstra();
		
		int ans = 0;
		long cost = 0;
		for(int i = 1; i <= N; i++) {
			if(distances[i] > cost) {
				ans = i;
				cost = distances[i];
			}
		}
		
		System.out.println(ans);
		System.out.println(cost);
		
	}

	private static void dijkstra() {
		boolean[] visited = new boolean[N + 1];
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.cost > distances[now.dest])
				continue;

			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					distances[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
			
		}
		
	}

}