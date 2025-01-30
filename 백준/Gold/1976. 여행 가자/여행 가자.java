import java.util.*;
import java.io.*;

public class Main {

	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		init(N);
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					union(i, j);
			}
		}
		st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());
			if(union(now, next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.print("YES");

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