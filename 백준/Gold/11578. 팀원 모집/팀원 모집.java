import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] lists;
	static boolean[] visited;
	static int ans = 11;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M];
		lists = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			lists[i] = new ArrayList<>();
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k; j++)
				lists[i].add(Integer.parseInt(st.nextToken()) - 1);
		}
		comb(0, 0);
		System.out.println((ans < 11) ? ans : -1);
	}
	
	private static void comb(int cnt, int idx) {
		if(cnt >= ans)
			return;
		if(idx == M) {
			boolean[] solves = new boolean[N];
			for(int i = 0; i < M; i++) {
				if(visited[i]) {
					for(int v : lists[i])
						solves[v] = true;
				}
			}
			boolean check = true;
			for(boolean c : solves) {
				if(!c) {
					check = false;
					break;
				}
			}
			if(check)
				ans = Math.min(ans, cnt);
			
			return;
		}
		
		for(int i = idx; i < M; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
			comb(cnt, i + 1);
		}
		
	}
}
