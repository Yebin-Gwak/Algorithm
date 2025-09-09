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
	static ArrayList<Node>[] lists;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			lists[start].add(new Node(dest, cost));
			lists[dest].add(new Node(start, cost));
		}
		
		int[] dests = new int[10];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)
			dests[i] = Integer.parseInt(st.nextToken());
		int myStart = Integer.parseInt(br.readLine());
		if(dests[0] == myStart) {
			System.out.println(myStart);
			return;
		}
		long[] myDistances = new long[10];
		Arrays.fill(myDistances, Long.MAX_VALUE);
		long[] herDistances = new long[10];
		
		for(int i = 0; i < 10; i++)
			myDistances[i] = dijkstra(myStart, dests[i]);
		long hd = 0;
		int before = dests[0];
		for(int i = 1; i < 10; i++) {
			long d = dijkstra(before, dests[i]);
			if(d == -1) {
				herDistances[i] = -1;
				continue;
			}
			
			hd += d;
			herDistances[i] = hd;
			before = dests[i];
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i < 10; i++) {
			if(myDistances[i] != -1 && herDistances[i] != -1 
					&& myDistances[i] <= herDistances[i] && dests[i] < ans)
				ans = dests[i];
		}
		
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
		
	}
	
	private static long dijkstra(int start, int end) {
		long[] distances = new long[N + 1];
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[start] = 0;
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.dest == end)
				return now.cost;
			
			if(now.cost != distances[now.dest])
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
		
		return -1;
	}
}
