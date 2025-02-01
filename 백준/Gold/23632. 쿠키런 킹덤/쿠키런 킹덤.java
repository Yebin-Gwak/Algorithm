import java.util.*;
import java.io.*;

public class Main {
	static int N, M, T;
	static int[] wait;
	static boolean[] resources;
	static ArrayList<Integer>[] buildings;
	static ArrayList<Integer>[] needs;
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		wait = new int[N + 1];
		resources = new boolean[N + 1];
		buildings = new ArrayList[N + 1];
		needs = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			buildings[i] = new ArrayList<>();
			needs[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
			ans.add(Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int j = 0; j < K; j++)
				buildings[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N - M; i++) {
			st = new StringTokenizer(br.readLine());
			int building = Integer.parseInt(st.nextToken());
			int need = Integer.parseInt(st.nextToken());
			wait[building] = need;
			for(int j = 0; j < need; j++)
				needs[Integer.parseInt(st.nextToken())].add(building);
		}
		
		topologySort();
		Collections.sort(ans);
		sb.append(ans.size() + "\n");
		for(int n : ans)
			sb.append(n + " ");
			
		
		System.out.print(sb.toString().trim());
	}


	private static void topologySort() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for(int n : ans)
			deque.add(n);
		ans.clear();
		
		for(int t = 0; t <= T; t++) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				int now = deque.poll();
				ans.add(now);
				for(int resource : buildings[now]) {
					if(resources[resource])
						continue;
					resources[resource] = true;
					for(int next : needs[resource]) {
						if(--wait[next] == 0)
							deque.add(next);
					}
				}
			}
		}
	} 
}
