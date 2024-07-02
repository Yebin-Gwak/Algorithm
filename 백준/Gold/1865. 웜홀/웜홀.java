import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int dest, cost;
		
		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

	}
	static int N, M, W;
	static int[] distances;
	static List<Node>[] nodes;
	static boolean answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		w : for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			answer = false;
			distances = new int[N + 1];
			
			nodes = new List[N + 1];
			for(int i = 1; i <= N; i++)
				nodes[i] = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				nodes[start].add(new Node(end, distance));
				nodes[end].add(new Node(start, distance));
			}
			
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				nodes[start].add(new Node(end, -distance));
			}

			for(int i = 1; i <= N; i++) {
				if(belmanford(i)) {
					sb.append("YES").append("\n");
					continue w;
				}
				
			}
			
			sb.append("NO").append("\n");
		}
		System.out.print(sb.toString());
	}

	private static boolean belmanford(int start) {
		Arrays.fill(distances, 10000000);
		distances[start] = 0;
		
		for(int i = 0; i < N - 1; i++) {
			boolean update = false;
			for(int j = 1; j <= N; j++) {
				for(Node next : nodes[j]) {
					if(distances[j] != 10000000 && distances[next.dest] > distances[j] + next.cost) {
						distances[next.dest] = distances[j] + next.cost;
						update = true;
					}
				}
				
			}
			if(!update)
				break;
		}
		
		for(int j = 1; j <= N; j++) {
			for(Node next : nodes[j]) {
				if(distances[j] != 10000000 && distances[next.dest] > distances[j] + next.cost) {
					return true;
				}
			}
			
		}
		return false;
		
	}

}