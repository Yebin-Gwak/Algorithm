import java.util.*;
import java.io.*;

public class Main {
	
	static class Voice{
		long cnt;
		long end;
		
		public Voice(long cnt, long end) {
			this.cnt = cnt;
			this.end = end;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] arr = new long[N][2];
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				arr[j][i] = Long.parseLong(st.nextToken());
		}
		
		long power = 0;
		long curCnt = 0;
		long ans = 0;
		
		PriorityQueue<Voice> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.end, o2.end));
		for(int i = 0; i < N; i++) {
			power -= curCnt;
			if(!pq.isEmpty() && pq.peek().end == i)
				curCnt -= pq.poll().cnt;
			
			long now = arr[i][0];
			long goal = arr[i][1];
			if(now + power >= goal)
				continue;
			goal -= now + power;
			long cnt = goal / K;
			cnt += (goal % K != 0) ? 1 : 0;
			power += K * cnt;
			curCnt += cnt;
			ans += cnt;
			pq.add(new Voice(cnt, i + K));
			
		}
		
		System.out.println(ans);
		
	}
}