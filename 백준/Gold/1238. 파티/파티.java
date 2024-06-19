import java.util.*;
import java.io.*;

public class Main{
	static class Node implements Comparable<Node>{
		int dest, cost;

		public Node(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, M, X;
	static List<Node>[] nodes;
	static boolean[] visited;
	static int[] distances;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int answer = -1;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		distances = new int[N + 1];
		visited = new boolean[N + 1];
		nodes = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++)
			nodes[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(dest, cost));
		}
		
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			dijkstra(i, X);
			sum += distances[X];
			dijkstra(X, i);
			sum += distances[i];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}


	private static void dijkstra(int start, int dest) {
		pq.clear();
		pq.add(new Node(start, 0));
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		
		distances[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : nodes[now.dest]) {
				if(!visited[next.dest] && distances[next.dest] > distances[now.dest] + next.cost) {
					distances[next.dest] = distances[now.dest] + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
			if(visited[dest])
				return;
		}
		
	}
}