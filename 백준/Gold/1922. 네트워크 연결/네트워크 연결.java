
import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;
		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}
		
		
		
	}
	static int N, M;
	static int cost = 0;
	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		make();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(from, to, cost));
		}
		
		while(N != 1) {
			Node node = pq.poll();
			if(union(node.from, node.to)) {
				N--;
				cost += node.cost;
			}
		}
		
		System.out.println(cost);
		
	}

	private static void make() throws IOException {
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parents[i] = i;
		
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = parents[aRoot];
		return true;
	}
	
}