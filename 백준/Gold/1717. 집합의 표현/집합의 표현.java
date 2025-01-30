import java.util.*;
import java.io.*;

public class Main {

	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		init(N);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(c == 0)
				union(a, b);
			else
				sb.append((find(a) == find(b)) ? "YES" : "NO").append("\n");
		}
		System.out.print(sb.toString());

	}
	
	private static void init(int N) {
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