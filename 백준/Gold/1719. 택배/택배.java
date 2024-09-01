import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node> {
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
	static List<Node>[] routes;
	static int[] distances;
	static boolean[] visited;
	static int[][] answer;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		routes = new List[N + 1];
		for (int i = 1; i <= N; i++)
			routes[i] = new ArrayList<Node>();
		distances = new int[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		answer = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			routes[start].add(new Node(end, cost));
			routes[end].add(new Node(start, cost));
		}

		for(int i = 1; i <= N; i++)
			diskstra(i);
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				sb.append((i == j) ? "-" : answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());

	}

	private static void diskstra(int start) {
		pq.clear();
		pq.add(new Node(start, 0));
		distances[start] = 0;
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(visited, false);

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(now.cost > distances[now.dest])
				continue;

			if (!visited[now.dest])
				visited[now.dest] = true;

			for (Node next : routes[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					distances[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, distances[next.dest]));
					answer[next.dest][start] = now.dest;
				}
			}

		}

	}
}