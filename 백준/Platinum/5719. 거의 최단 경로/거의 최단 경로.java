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
	static int startPoint, endPoint;
	static List<Node>[] routes = new List[500];
	static int[] distances;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static boolean[][] removed;
	static HashSet<Integer>[] prev = new HashSet[500];
	static int maxLength;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 500; i++) {
			routes[i] = new ArrayList<>();
			prev[i] = new HashSet<>();
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			init();
			st = new StringTokenizer(br.readLine());
			startPoint = Integer.parseInt(st.nextToken());
			endPoint = Integer.parseInt(st.nextToken());

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				routes[start].add(new Node(dest, cost));
			}
			
			firstDijkstra();
			
			Arrays.fill(visited, false);
			visited[endPoint] = true;
			remove(endPoint);
			
			pq.clear();
			Arrays.fill(visited, false);
			Arrays.fill(distances, Integer.MAX_VALUE);
			
			int answer = secondDijkstra();
			sb.append(answer).append("\n");
			
		}
		System.out.print(sb.toString());
	}

	private static void firstDijkstra() {
		pq.add(new Node(startPoint, 0));
		distances[startPoint] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.cost > maxLength)
				return;
			
			if(now.dest == endPoint) {
				maxLength = Math.min(maxLength, now.cost);
				continue;
			}
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : routes[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost <= distances[next.dest]) {
					if(now.cost + next.cost < distances[next.dest]) {
						distances[next.dest] = now.cost + next.cost;
						prev[next.dest].clear();
					}
					if(prev[next.dest].contains(now.dest))
						continue;
					prev[next.dest].add(now.dest);
					pq.add(new Node(next.dest, distances[next.dest]));

				}
			}
			
		}
		
	}
	
	private static void remove(int v) {
		for(int parent : prev[v]) {
			if(!removed[parent][v]) {
				removed[parent][v] = true;
				if(!visited[parent]) {
					visited[parent] = true;
					remove(parent);
				}
			}
		}
	}

	private static int secondDijkstra() {
		pq.add(new Node(startPoint, 0));
		distances[startPoint] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.dest == endPoint) {
				return now.cost;
			}
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : routes[now.dest]) {
				if(!removed[now.dest][next.dest] && !visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					distances[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
				}
			}
			
		}
		return -1;
	}
	
	private static void init() {
		for(int i = 0; i < N; i++) {
			routes[i].clear();
			prev[i].clear();
		}
		distances = new int[N];
		Arrays.fill(distances, Integer.MAX_VALUE);
		visited = new boolean[N];
		removed = new boolean[N][N];
		pq.clear();
		maxLength = Integer.MAX_VALUE;
	}
}