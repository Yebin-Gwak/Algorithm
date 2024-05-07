import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int num;
		int time;

		public Node(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
	static int N, D, C;
	static List<Node>[] list;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int count;
	static int time;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			list = new List[N + 1];
			for(int i = 1; i <= N; i++)
				list[i] = new ArrayList<Node>();
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new Node(a, s));
			}
			count = 0;
			time = 0;
			bfs(C);
			sb.append(count + " " + time + "\n");
		}
		System.out.println(sb.toString());
	}
	private static void bfs(int start) {
		visited = new boolean[N + 1];
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.num]) continue;
			visited[node.num] = true;
			count++;
			time = Math.max(time, node.time);
			for(Node n : list[node.num]) {
				if(visited[n.num]) continue;
				pq.add(new Node(n.num, node.time + n.time));
			}
		}
		
	}

}