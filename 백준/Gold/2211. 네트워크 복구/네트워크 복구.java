import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int start;
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		public Node(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, M, K;
	static ArrayList<Node>[] routes;
	static int[] distance;
	static boolean[] visited;
	static Deque<Node> deque = new ArrayDeque<Node>();
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static List<int[]> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		routes = new ArrayList[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++)
			routes[i] = new ArrayList<Node>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			routes[start].add(new Node(dest, cost));
			routes[dest].add(new Node(start, cost));
		}
		
		dijkstra(1);
		
		sb.append(K).append("\n");
		for(int[] route: answer) {
			sb.append(route[0] + " " + route[1]).append("\n");
		}
		System.out.print(sb.toString());
		
	}

	private static void dijkstra(int start) {
		pq.add(new Node(start, start, 0));
		visited[start] = true;
		distance[start] = 0;
		answer = new ArrayList<int[]>();

		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.dest]) {
				visited[now.dest] = true;
				K++;
				answer.add(new int[] {now.start, now.dest});
			}
			 
			for(Node next : routes[now.dest]) {
				if(!visited[next.dest] && distance[next.dest] > distance[now.dest] + next.cost) {
					distance[next.dest] = distance[now.dest] + next.cost;
					pq.add(new Node(now.dest, next.dest, distance[next.dest]));
				}
			}
		}
		
	}
}
