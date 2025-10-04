import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[c] = p;
			}
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N + 1];
			
			check(A);
			sb.append(check(B) + "\n");
		}
		System.out.print(sb);
	}
	
	private static int check(int node) {
		if(visited[node] || arr[node] == 0)
		return node;
		visited[node] = true;
		return check(arr[node]);
	}
}