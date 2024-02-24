import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] in, times, dp;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		//자신이 작업하기 전 수행되야 할 선행노드의 개수
		in = new int[N + 1];
		// 각 작업들에 걸리는 시간
		times = new int[N + 1];
		// 각 작업을 마치고 난 시간
		dp = new int[N + 1];
		
		//현재 자신을 선행노드로 지정한 노드들
		list = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			times[i] = Integer.parseInt(st.nextToken());
			int nodes = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < nodes; j++) {
				int e = Integer.parseInt(st.nextToken());
				list[i].add(e);
				++in[e];

			}
		}

		calc();
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
	}
	
	private static void calc() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				dp[i] = times[i];
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int v = q.poll(); // 진입이 0인 정점

			for (int i = 0; i < list[v].size(); i++) {
				int e = list[v].get(i);

				dp[e] = Math.max(dp[e], dp[v] + times[e]);
				if (--in[e] == 0) {
					q.offer(e);
				}

			}

		}
	}

}