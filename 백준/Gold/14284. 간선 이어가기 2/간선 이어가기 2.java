import java.io.*;
import java.util.*;

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
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		distances = new int[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lists[start].add(new Node(dest, cost));
			lists[dest].add(new Node(start, cost));
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(s, t));
		
	}

	private static int dijkstra(int s, int t) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		pq.add(new Node(s, 0));
		distances[s] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.dest == t)
				return distances[now.dest];
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			if(now.cost > distances[now.dest])
				continue;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					distances[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
		}
		
		return -1;
	}

}
