import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++)
			parents[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N - 1; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(find(now) != find(next))
				cnt++;
			now = next;
		}
		
		System.out.println(cnt);
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return;
		parents[bRoot] = parents[aRoot];
	}

}