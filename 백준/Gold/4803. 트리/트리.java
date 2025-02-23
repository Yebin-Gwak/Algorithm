import java.util.*;
import java.io.*;

public class Main {

	static int[] parents;
	static boolean[] trees;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			tc++;
			
			parents = new int[N + 1];
			for(int i = 1; i <= N; i++)
				parents[i] = i;
			trees = new boolean[N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(!trees[find(i)]) {
					cnt++;
					trees[parents[i]] = true;
				}
			}
			
			sb.append("Case " + tc + ": ");
			if(cnt == 0)
				sb.append("No trees.");
			else if(cnt == 1)
				sb.append("There is one tree.");
			else
				sb.append("A forest of " + cnt + " trees.");
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			trees[aRoot] = true;
			return;
		}
		if(trees[aRoot] || trees[bRoot]) {
			trees[aRoot] = true;
			trees[bRoot] = true;
		}
		parents[bRoot] = parents[aRoot];
	}

}
