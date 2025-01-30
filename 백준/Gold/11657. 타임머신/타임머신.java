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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] nodes = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			nodes[i] = new ArrayList<>();
		long[] distances = new long[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[s].add(new Node(e, c));
		}
		
		distances[1] = 0;
		for(int i = 1; i < N; i++) {
			for(int now = 1; now <= N; now++) {
				if(distances[now] == Integer.MAX_VALUE)
					continue;
				for(Node next : nodes[now]) {
					if(distances[now] + next.cost < distances[next.dest]) {
						distances[next.dest] = distances[now] + next.cost;
					}
				}
			}
		}
		
		for(int now = 1; now <= N; now++) {
			if(distances[now] == Integer.MAX_VALUE)
				continue;
			for(Node next : nodes[now]) {
				if(distances[now] + next.cost < distances[next.dest]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		for(int i = 2; i <= N; i++)
			sb.append((distances[i] == Integer.MAX_VALUE) ? -1 : distances[i]).append("\n");
		
		System.out.print(sb.toString());
		
	}
}