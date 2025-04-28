import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] rank;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		rank = new int[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			rank[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
		
	}

	private static int bfs() {
		if(rank[1] != 1)
			return 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		visited[1] = true;
		HashSet<Integer> set;
		int idx = 2;
		
		while(!dq.isEmpty()) {
			int now = dq.poll();
			set = new HashSet<>();
			
			for(int next : list[now]) {
				if(!visited[next]) {
					visited[next] = true;
					set.add(next);
				}
			}
			
			for(int i = 0; i < set.size(); i++) {
				if(!set.contains(rank[idx]))
					return 0;
				dq.add(rank[idx++]);
			}
			
		}
		
		return 1;
	}

}
