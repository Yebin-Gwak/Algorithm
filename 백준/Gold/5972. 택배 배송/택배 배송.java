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
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, M;
	static List<Node>[] lists;
	static int[] distances;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distances = new int[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lists[start].add(new Node(end, cost));
			lists[end].add(new Node(start, cost));
		}
		
		dijkstra();
		System.out.println(distances[N]);
		
	}

	private static void dijkstra() {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.dest])
				visited[now.dest] = true;
			if(now.dest == N)
				return;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					 distances[next.dest] = now.cost + next.cost;
					 pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
		}
		
	}
}
