import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static class Node implements Comparable<Node>{
		int dest;
		int cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	static int N, M;
	static List<Node>[] lists;
	static int[] parents;
	static int[] distances;
	static ArrayList<Integer> path;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			init();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				lists[from].add(new Node(to, cost));
				lists[to].add(new Node(from, cost));
			}
			
			dijkstra();
			path = new ArrayList<>();
			if(parents[N - 1] == -1)
				path.add(-1);
			else
				find(N - 1);
			
			Collections.reverse(path);
			
			sb.append("Case #" + t + ": ");
			for(int p : path)
				sb.append(p + " ");
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());

	}
	
	private static void init() {
		lists = new List[N];
		for(int i = 0; i < N; i++)
			lists[i] = new ArrayList<>();
		parents = new int[N];
		parents[0] = 0;
		Arrays.fill(parents, -1);
		distances = new int[N];
		distances[0] = 0;
		Arrays.fill(distances, Integer.MAX_VALUE);
	}
	
	private static void dijkstra() {
		boolean[] visited = new boolean[N];
		PriorityQueue<Node> deque = new PriorityQueue();
		deque.add(new Node(0, 0));
		
		while(!deque.isEmpty()) {
			Node now = deque.poll();
			
			if(now.dest == N)
				return;
			
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			for(Node next : lists[now.dest]) {
				if(!visited[next.dest] && now.cost + next.cost < distances[next.dest]) {
					parents[next.dest] = now.dest;
					distances[next.dest] = now.cost + next.cost;
					deque.add(new Node(next.dest, distances[next.dest]));
				}
			}
		}
		
	}
	
	private static void find(int v) {
		path.add(v);
		if(v == 0)
			return;
		find(parents[v]);
	}

}