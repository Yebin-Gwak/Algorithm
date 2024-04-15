import java.io.*;
import java.util.*;

public class Main {
	static class Move implements Comparable<Move>{
		int time, dest;

		public Move(int time, int dest) {
			super();
			this.time = time;
			this.dest = dest;
		}

		@Override
		public int compareTo(Move o) {
			if(this.time == o.time)
				return this.dest - o.dest;
			return this.time - o.time;
		}
		
	}
	
	static PriorityQueue<Move> pq;
	static int N, K;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		int ans = search();
		System.out.println(ans);
	}

	private static int search() {
		pq = new PriorityQueue<>();
		visited[N] = true;
		pq.add(new Move(0, N));
		
		while(true) {
			Move now = pq.poll();
			if(now.dest == K)
				return now.time;
			
			if(now.dest * 2 <= 100000 && !visited[now.dest * 2]) {
				visited[now.dest * 2] = true;
				pq.add(new Move(now.time, now.dest * 2));
			}
			if(0 <= now.dest - 1 && !visited[now.dest - 1]) {
				visited[now.dest - 1] = true;
				pq.add(new Move(now.time + 1, now.dest - 1));
			}
			if(now.dest + 1 <= 100000 && !visited[now.dest + 1]) {
				visited[now.dest + 1] = true;
				pq.add(new Move(now.time + 1, now.dest + 1));
			}
			
		}
		
		
	}

}