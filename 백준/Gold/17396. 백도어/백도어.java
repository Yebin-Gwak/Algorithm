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
			return Long.compare(this.cost, o.cost);
		}

	}
	
	static int N, M;
	static List<Node>[] lists;
	static long[] distances;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N];
		for(int i = 0; i < N; i++)
			lists[i] = new ArrayList<>();
		distances = new long[N];
		Arrays.fill(distances, Long.MAX_VALUE);
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n == 1)
				visited[i] = true;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(visited[start] || visited[dest])
				continue;
			lists[start].add(new Node(dest, cost));
			lists[dest].add(new Node(start, cost));
		}
		
		System.out.println(dijkstra());
		
	}
	private static long dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		distances[0] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.dest == N - 1)
				return now.cost;
			
			if(now.cost > distances[now.dest])
				continue;
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && distances[now.dest] + next.cost < distances[next.dest]) {
					distances[next.dest] = distances[now.dest] + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
		}
		
		return -1;
	}

}