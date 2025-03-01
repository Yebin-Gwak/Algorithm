import java.util.*;
import java.io.*;

public class Main {

	static int root;
	static int[] parents;
	static List<Integer>[] lists;
	static boolean[] visited;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		lists = new ArrayList[N];
		for(int i = 0; i < N; i++)
			lists[i] = new ArrayList<>();
		parents = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if(p == -1) {
				root = i;
				parents[i] = i;
				continue;
			}
			lists[p].add(i);
			parents[i] = p;
		}
		
		int removed = Integer.parseInt(br.readLine());
		if(root == removed) {
			System.out.println(0);
			return;
		}
		lists[removed].clear();
		lists[parents[removed]].remove((Integer) removed);
		visited[root] = true;
		dfs(root);
		
		System.out.println(ans);
	}
	
	private static void dfs(int v) {
		if(lists[v].isEmpty()) {
			ans++;
			return;
		}
		
		for(int next : lists[v]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
		
	}

}