import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;
        List<Integer> route;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        
		public Node(int dest, int cost, List<Integer> route) {
			this.dest = dest;
			this.cost = cost;
			this.route = route;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [dest=" + dest + ", cost=" + cost + ", route=" + route + "]";
		}
		
    }
	
	static int N, M, first, end;
	static List<Node>[] nodes;
	static boolean[] visited;
	static int[] distances;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		nodes = new List[N + 1];
		visited = new boolean[N + 1];
		distances = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			nodes[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(dest, cost));
		}
		st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		
		
		Node answer = dijkstra(first);
		sb.append(answer.cost).append("\n");
		sb.append(answer.route.size()).append("\n");
		for(int a : answer.route)
			sb.append(a).append(" ");
		System.out.println(sb.toString().trim());
		
		
	}


	private static Node dijkstra(int start) {
		Arrays.fill(distances, Integer.MAX_VALUE);
		List<Integer> list = new ArrayList<>();
		list.add(start);
		pq.add(new Node(start, 0, list));
		distances[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.dest])
				visited[now.dest] = true;
			
			if(visited[end])
				return now;
			
			for(Node next : nodes[now.dest]) {
				if(!visited[next.dest] && distances[next.dest] > now.cost + next.cost) {
					distances[next.dest] = now.cost + next.cost;
					List<Integer> temp = new ArrayList<>(now.route);
					temp.add(next.dest);
					pq.add(new Node(next.dest, distances[next.dest], temp));
				}
			}
		}
		
		return null;
	}

}