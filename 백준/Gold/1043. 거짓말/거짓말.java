import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] parents;
	static boolean[] trueMans;
	static List<Integer>[] parties;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i = 0; i < t; i++)
			trueMans[Integer.parseInt(st.nextToken())] = true;
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens())
				parties[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int j = 0; j < M; j++) {
			for(int i = 1; i <= M; i++)
				check(i);
			
		}
		
		for(int i = 1; i <= M; i++)
			talk(i);
		
		System.out.println(answer);
	}
	
	private static void talk(int party) {
		if(parties[party].size() == 0)
			return;
		
		for(int man : parties[party]) {
			if(trueMans[find(man)])
				return;
		}
		answer++;

	}

	private static void check(int party) {
		int knowMan = -1;
		for(int man : parties[party]) {
			if(trueMans[find(man)]) {
				knowMan = man;
				break;
			}
		}
		
		if(knowMan != -1) {
			for(int man : parties[party])
				union(knowMan, man);
		}

	}

	private static void make() {
		trueMans = new boolean[N + 1];
		parents = new int[N + 1];
		for(int i = 1; i <= N; i++)
			parents[i] = i;
		parties = new ArrayList[M + 1];
		for(int i = 1; i <= M; i++)
			parties[i] = new ArrayList<>();
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		trueMans[b] = true;
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = parents[aRoot];
		return true;
	}
}
