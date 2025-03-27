import java.io.*;
import java.util.*;

public class Main {
	
	static class Line implements Comparable<Line>{
		int x;
		int y;
		
		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Line o) {
			if(this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Line> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Line(x + 1000000000, y + 1000000000));
		}
		
		Line now = pq.poll();
		int ans = 0;
		while(!pq.isEmpty()) {
			Line next = pq.poll();
			if(next.x > now.y) {
				ans += now.y - now.x;
				now = next;
				continue;
			}
			
			now.y = Math.max(now.y, next.y);
			
		}
		ans += now.y - now.x;
		
		System.out.println(ans);
		
	}

}