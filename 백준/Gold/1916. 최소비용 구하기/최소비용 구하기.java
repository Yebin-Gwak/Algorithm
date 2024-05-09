import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int num;
		int time;

		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	
	}
	static int N, D, S, E;
	static List<Node>[] list;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		D = Integer.parseInt(br.readLine());
		list = new List[N + 1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Node>();
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, s));
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		bfs();
	}
	private static void bfs() {
		visited = new boolean[N + 1];
		pq.add(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.num]) continue;
			if(node.num == E) {
				System.out.println(node.time);
				return;
			}
			visited[node.num] = true;

			for(Node n : list[node.num]) {
				if(visited[n.num]) continue;
				pq.add(new Node(n.num, node.time + n.time));
			}
		}
		
	}

}