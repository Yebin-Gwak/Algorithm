import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int start, end, cost;

		public Node(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int N, M;
	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			
			make();
			
			int total = 0;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				pq.add(new Node(start, end, cost));
				total += cost;
			}
			
			int cnt = 0;
			int answer = 0;
			while(cnt != N - 1) {
				Node now = pq.poll();
				if(union(now.start, now.end)) {
					answer += now.cost;
					cnt++;
				}
			}
			sb.append(total - answer + "\n");
			
		}
		System.out.print(sb.toString());
	}
	private static void make() {
		pq.clear();
		parents = new int[N];
		for(int i = 0; i < N; i++)
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
