import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int N, M, K;
	static List<Node>[] lists;
	static int[] distances;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		distances = new int[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lists[s].add(new Node(e, cost));
		}
		
		dijkstra();
		
		for(int i = 1; i <= N; i++)
			sb.append((distances[i] == Integer.MAX_VALUE) ? "INF" : distances[i]).append("\n");
		
		System.out.print(sb.toString());
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N + 1];
		distances[K] = 0;
		pq.add(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && distances[now.dest] + next.cost < distances[next.dest]) {
					distances[next.dest] = distances[now.dest] + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
			
		}
	}

}