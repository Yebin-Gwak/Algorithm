import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int height, start, end, up, down, count;
//	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		visited = new boolean[height + 1];
		
		int ans = bfs(start);
		if(ans == -1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);
		
//		ans = Integer.MAX_VALUE;

//		dfs(start, 0); //시간초과
//		if (ans == Integer.MAX_VALUE)
//			System.out.println("use the stairs");
//		else
//			System.out.println(ans);

	}

	private static int bfs(int start) {
		Deque<Integer> deque = new ArrayDeque<>();
		visited[start] = true;
		count = -1;
		deque.addLast(start);
		
		while (!deque.isEmpty()) {
			count++;
			int n = deque.size();
			for (int i = 0; i < n; i++) {
				int now = deque.pollFirst();
				if (now == end)
					return count;
				
				if ((now + up <= height) && visited[now + up] == false) {
					deque.addLast(now + up);
					visited[now + up] = true;
				}
				
				if ((now - down > 0) && visited[now - down] == false) {
					deque.addLast(now - down);
					visited[now - down] = true;
				}
				
			}
			
		}
		return -1;
	}
	
//	private static void dfs(int start, int count) {
//		if (start == end) {
//			ans = Math.min(ans, count);
//			return;
//		}
//
//		visited[start] = true;
//
//		if ((start + up <= height) && visited[start + up] == false) {
//			dfs(start + up, count + 1);
//			visited[start + up] = false;
//		}
//		if ((start - down > 0) && visited[start - down] == false) {
//			dfs(start - down, count + 1);
//			visited[start - down] = false;
//		}
//
//	}


}