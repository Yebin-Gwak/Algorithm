import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[]map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		make();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 1)
					union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		start = find(start);
		boolean check = true;
		
		for(int i = 0; i < M - 1; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(start != find(v)) {
				check = false;
				break;
			}
		}
		
		if(!check)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

	
	private static void make() {
		map = new int[N + 1];
		for(int i = 1; i <= N; i++)
			map[i] = i;
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		map[bRoot] = map[aRoot];
		return true;
	}
	
	private static int find(int a) {
		if(map[a] == a)
			return a;
		return map[a] = find(map[a]);
	}

}