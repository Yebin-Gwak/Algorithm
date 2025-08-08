import java.util.*;
import java.io.*;

public class Main {

	static class Node implements Comparable<Node>{
		int dest;
		long cost;
		boolean isDouble;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		public Node(int dest, long cost, boolean isDouble) {
			this.dest = dest;
			this.cost = cost;
			this.isDouble = isDouble;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	static int N, M;
	static ArrayList<Node>[] lists;
	static long[] distances;
	static long[][] wolfDistances;
	
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
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) * 2;
			lists[s].add(new Node(e, c));
			lists[e].add(new Node(s, c));
		}
		
		dijkstra();
		wolfDijkstra();
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			long wolf = Math.min(wolfDistances[i][0], wolfDistances[i][1]);
			if(distances[i] < wolf)
				cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distances = new long[N + 1];
		Arrays.fill(distances, Long.MAX_VALUE);
		distances[1] = 0;
		boolean[] visited = new boolean[N + 1];
		
		pq.add(new Node(1, 0, true));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.cost != distances[now.dest])
				continue;
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					distances[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, distances[next.dest], true));
				}
				
			}
		}
		
	}
	
	private static void wolfDijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		wolfDistances = new long[N + 1][2];
		for(int i = 0; i <= N; i++)
			Arrays.fill(wolfDistances[i], Long.MAX_VALUE);
		wolfDistances[1][1] = 0;
		
		boolean[][] visited = new boolean[N + 1][2];
		
		pq.add(new Node(1, 0, false));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int idx = now.isDouble ? 0 : 1;
			int nextIdx = Math.abs(idx - 1);
			
			if(now.cost != wolfDistances[now.dest][idx])
				continue;
			
			if(!visited[now.dest][idx])
				visited[now.dest][idx] = true;
			
			for(Node next : lists[now.dest]) {
				long nc = (now.isDouble) ? next.cost * 2 : next.cost / 2;
				if(!visited[next.dest][nextIdx] && now.cost + nc < wolfDistances[next.dest][nextIdx]) {
					wolfDistances[next.dest][nextIdx] = now.cost + nc;
					pq.add(new Node(next.dest, wolfDistances[next.dest][nextIdx], !now.isDouble));
				}
				
			}
		}
		
	}
}
