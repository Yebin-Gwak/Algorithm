import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int max = 0;
	static int[] arr;
	static ArrayList<Integer>[] lists;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		lists = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			lists[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lists[s].add(e);
		}
		for (int v = 1; v <= N; v++)
			bfs(v);

		for(int n : arr) 
			max = Math.max(max, n);
		
		for(int i = 1; i <= N; i++) {
			if(arr[i] == max)
				sb.append(i + " ");
		}
		
		System.out.print(sb.toString().trim());
	}

	private static void bfs(int v) {
		boolean[] visited = new boolean[N + 1];
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		visited[v] = true;
		deque.add(v);
		
		while (!deque.isEmpty()) {
			int now = deque.poll();
			arr[now]++;
			for (int n : lists[now]) {
				if (!visited[n]) {
					visited[n] = true;
					deque.add(n);
				}
			}
		}
	}
}