import java.util.*;
import java.io.*;

public class Main {
	static class Hole implements Comparable<Hole>{
		int start;
		int end;
		
		public Hole(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Hole o) {
			return this.end - o.end;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int ans = 0;
		int len = -1;
		
		PriorityQueue<Hole> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) - 1;
			pq.add(new Hole(start, end));
		}
		
		while(!pq.isEmpty()) {
			Hole now = pq.poll();
			if(len >= now.end)
				continue;
			
			int start = (len >= now.start) ? len : now.start - 1;
			int cnt = ((now.end - start) / L);
			
			cnt += (((now.end - start) % L == 0) ? 0 : 1);
			len = start + (cnt * L);
			ans += cnt;
		}
		
		System.out.println(ans);

	}
}
