import java.io.*;

public class Main {
	static int G, P;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		make();
		
		for(int i = 0; i < P; i++) {
			int v = Integer.parseInt(br.readLine());
			if(find(v) == 0) {
				System.out.println(i);
				return;
			}
			else {
				union(find(v), find(v) - 1);
			}
		}
		System.out.println(P);
		
	}
	
	
	private static void make() {
		parents = new int[G + 1];
		for(int i = 1; i <= G; i++)
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
		parents[aRoot] = parents[bRoot];
		return true;
	}
	
}