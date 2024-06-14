import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int from, to, cost;
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
	static int N, M;
	static int cost = 0;
	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
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

	private static void make() {
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