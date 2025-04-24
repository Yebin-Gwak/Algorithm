import java.io.*;
import java.util.*;

public class Main {
	
	static class Slime{
		long start;
		long end;
		
		public Slime(long start, long end) {
			this.start = start;
			this.end = end;
		}

	}

	static int N, X;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Slime> ready = new PriorityQueue<>((o1, o2) -> Long.compare(o1.start, o2.start));
		PriorityQueue<Slime> run = new PriorityQueue<>((o1, o2) -> Long.compare(o1.end, o2.end));
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int inc = Integer.parseInt(st.nextToken());
			int dec = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			int grown = X / inc + ((X % inc != 0) ? 1 : 0);
			if(inc * (grown - 1) >= max)
				continue;
			long limit = max / inc + ((max % inc != 0) ? 1 : 0);
			long v = limit * inc;
			long cut = (v - X + 1) / dec + (((v - X + 1) % dec != 0) ? 1 : 0);
			ready.add(new Slime(t + grown, t + limit + cut));
		}

		long prev = 0;
		long now = 0;
		long ans = 0;
		boolean flag = false;
		while(true) {
			now = Math.min((!ready.isEmpty() ? ready.peek().start : Long.MAX_VALUE), (!run.isEmpty() ? run.peek().end : Long.MAX_VALUE));
			if(now == Long.MAX_VALUE)
				break;
			
			while(!run.isEmpty() && run.peek().end == now)
				run.poll();
			
			while(!ready.isEmpty() && ready.peek().start == now)
				run.add(ready.poll());
			
			if(run.size() >= 3) {
				if(!flag) {
					flag = true;
					prev = now;
				}
			}else {
				if(flag) {
					flag = false;
					ans += now - prev;
				}
			}
			
		}
		
		System.out.println(ans);
		
	}

}