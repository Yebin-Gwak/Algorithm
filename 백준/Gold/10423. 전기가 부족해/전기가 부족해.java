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
	
	static int N, M, K;
	static List<Node>[] routes;
	static int[] distances;
	static boolean[] visited;
	
	static ArrayList<Integer> center = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		routes = new List[N + 1];
		for(int i = 1; i <= N; i++) {
			routes[i] = new ArrayList<>();
		}
		
		distances = new int[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < K; i++) {
			center.add(Integer.parseInt(st.nextToken()));
		}
			
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			routes[start].add(new Node(end, cost));
			routes[end].add(new Node(start, cost));
		}
		
		dijkstra();
		
		distances[0] = 0;
		int answer = 0;
		
		for(int n : distances)
			answer += n;
		System.out.println(answer);
	}



	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int n : center) {
			pq.add(new Node(n, 0));
			distances[n] = 0;
		}
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			else
				continue;
			
			for(Node next : routes[now.dest]) {
				if(!visited[next.dest] && next.cost < distances[next.dest]) {
					distances[next.dest] = next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
			
		}
		
	}
}
