import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		make();
		
		for(int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int start = find(1);
		for(int i = 1; i <= N; i++) {
			if(start != find(i)) {
				System.out.println(start + " " + i);
				return;
			}
		}

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