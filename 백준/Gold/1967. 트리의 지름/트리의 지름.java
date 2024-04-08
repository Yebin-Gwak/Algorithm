import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		int dest;
		int distance;

		public Node(int dest, int distance) {
			super();
			this.dest = dest;
			this.distance = distance;
		}

	}

	static List<Node>[] list;
	static int N;
	static boolean[] visited;
	static int max, maxV;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());


		list = new List[N + 1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<Node>();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			list[start].add(new Node(dest, distance));
			list[dest].add(new Node(start, distance));
		
		}


		visited = new boolean[N + 1];
		visited[1] = true;
		max = 0;
		maxV = 1;
		dfs(1, 0);
		
		visited = new boolean[N + 1];
		visited[maxV] = true;
		dfs(maxV, 0);
		
		System.out.println(max);
	}

	private static void dfs(int start, int sum) {
		if (sum > max) {
			max = sum;
			maxV = start;
		}

		for (Node next : list[start]) {
			if (!visited[next.dest]) {
				visited[next.dest] = true;
				dfs(next.dest, sum + next.distance);
				visited[next.dest] = false;
			}
		}

	}
}