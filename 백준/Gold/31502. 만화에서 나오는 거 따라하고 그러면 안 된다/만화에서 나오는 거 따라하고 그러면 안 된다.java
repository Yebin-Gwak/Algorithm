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
	
	static List<Node>[] list;
	static HashSet<Integer> set;
	static HashSet<Integer>[] routes;
	static long[] distances;
	static int N, M, toka, hanbyul, S;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		toka = Integer.parseInt(st.nextToken());
		hanbyul = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		distances = new long[N + 1];
		list = new ArrayList[N + 1];
		routes = new HashSet[N + 1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			routes[i] = new HashSet<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, c));
			list[e].add(new Node(s, c));
		}
		
		bfs();
		findRoute();
		move();
		
		System.out.println(ans);
		
	}
	private static void move() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distances, Long.MAX_VALUE);
		pq.add(new Node(toka, 0));
		distances[toka] = 0;
		long minCost = Long.MAX_VALUE;
		boolean flag = false;
		while(!flag) {
			int size = pq.size();
			for(int i = 0; i < size; i++) {
				Node now = pq.poll();
				
				if(set.contains(now.dest) && now.cost <= minCost) {
					flag = true;
					minCost = now.cost;
					ans = Math.min(ans, now.dest);
				}
				
				if(now.cost > minCost)
					return;
				
				if(now.cost > distances[now.dest])
					continue;
				
				if(!visited[now.dest])
					visited[now.dest] = true;
				
				for(Node next : list[now.dest]) {
					if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
						distances[next.dest] = now.cost + next.cost;
						pq.add(new Node(next.dest, distances[next.dest]));
					}
				}
				
			}
		}
		
	}
	
	private static void findRoute() {
		set = new HashSet<>();
		set.add(hanbyul);
		int now = hanbyul;
		while(now != S) {
			int next = 0;
			
			for(Node n : list[now]) {
				if(distances[n.dest] == distances[now] - 1) {
					if(list[n.dest].size() > list[next].size())
						next = n.dest;
					else if(list[n.dest].size() == list[next].size())
						next = Math.max(next, n.dest);
				}
			}
			set.add(next);
			now = next;
		}
	}

	private static void bfs() {
		Arrays.fill(distances, Long.MAX_VALUE);
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		distances[S] = 0;
		dq.add(S);
		
		while(!dq.isEmpty()) {
			int now = dq.poll();
			
			if(now == hanbyul) 
				break;
			
			for(Node next : list[now]) {
				if(distances[next.dest] == Long.MAX_VALUE) {
					distances[next.dest] = distances[now] + 1;
					dq.add(next.dest);
				}
			}
		}
		
	}

}