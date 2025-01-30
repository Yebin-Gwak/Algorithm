import java.util.*;
import java.io.*;

public class Main {
	
	static class Node{
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	static int N, S, E, M;
	static ArrayList<Node>[] nodes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N];
		for(int i = 0; i < N; i++)
			nodes[i] = new ArrayList<>();
		long[] distances = new long[N];
		Arrays.fill(distances, Integer.MIN_VALUE);
		long[] earns = new long[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[s].add(new Node(e, c));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			earns[i] = Integer.parseInt(st.nextToken());
		
		distances[S] = earns[S];
		for(int i = 0; i < N; i++) {
			for(int now = 0; now < N; now++) {
				if(distances[now] == Integer.MIN_VALUE)
					continue;
				for(Node next : nodes[now]) {
					if(distances[now] - next.cost + earns[next.dest] > distances[next.dest]) {
						distances[next.dest] = distances[now] - next.cost + earns[next.dest];
					}
				}
			}
		}
		
		if(distances[E] == Integer.MIN_VALUE) {
			System.out.println("gg");
			return;
		}
		
		for(int now = 0; now < N; now++) {
			if(distances[now] == Integer.MIN_VALUE)
				continue;
			for(Node next : nodes[now]) {
				if(distances[now] - next.cost + earns[next.dest] > distances[next.dest]) {
					if(bfs(next.dest)) {
						System.out.println("Gee");
						return;
					}
				}
			}
		}
		
		System.out.println(distances[E]);
	}
	
	private static boolean bfs(int start) {
		boolean[] visited = new boolean[N];
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(Node st : nodes[start]) {
			visited[st.dest] = true;
			deque.add(st.dest);
		}
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			if(now == E)
				return true;
			for(Node next : nodes[now]) {
				int d = next.dest;
				if(!visited[d]) {
					visited[d] = true;
					deque.add(d);
				}
			}
		}
		return false;
	}

}