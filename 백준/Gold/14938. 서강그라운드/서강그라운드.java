import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	static int V, E, N;
	static List<Node>[] nodes;
	static int[] items;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		items = new int[V + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= V; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		nodes = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++)
			nodes[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, cost));
			nodes[end].add(new Node(start, cost));
		}
		
		for(int i = 1; i <= V; i++)
			dijkstra(i);
		
		System.out.println(answer);
		
	}

	private static void dijkstra(int start) {
		visited = new boolean[V + 1];
		pq.add(new Node(start, 0));
		
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : nodes[now.dest]) {
				if(!visited[next.dest] && N >= now.cost + next.cost) {
					pq.add(new Node(next.dest, now.cost + next.cost));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(visited[i])
				sum += items[i];
		}
		answer = Math.max(answer, sum);
		
	}
}