import java.util.*;
import java.io.*;

public class Main {
	static class Problem{
		
		int ideaLv;
		int implLv;
		
		public Problem(int ideaLv, int implLv) {
			this.ideaLv = ideaLv;
			this.implLv = implLv;
		}
		
		public int getFailCnt() {
			return Math.max(implLv - hImpl, 0);
		}

	}

	static int N, M;
	static int hIdea, hImpl;
	static long failCnt = 0;
	
	static PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> o1.implLv - o2.implLv);
	static PriorityQueue<Problem> waitQueue = new PriorityQueue<>((o1, o2) -> o1.ideaLv - o2.ideaLv);
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ideaLv = Integer.parseInt(st.nextToken());
			int implLv = Integer.parseInt(st.nextToken());
			if(Integer.parseInt(st.nextToken()) == 1)
				implLv = 0;
			
			if(Integer.parseInt(st.nextToken()) == 1) {
				ideaLv = (ideaLv / 2) + (ideaLv % 2);
				implLv /= 2;
			}
			
			waitQueue.add(new Problem(ideaLv, implLv));
		}
		
		st = new StringTokenizer(br.readLine());
		hIdea = Integer.parseInt(st.nextToken());
		hImpl = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
		
	}
	
	private static long solve() {
		for(int i = 0; i < M; i++) {
			while(!waitQueue.isEmpty()) {
				if(waitQueue.peek().ideaLv <= hIdea)
					pq.add(waitQueue.poll());
				else
					break;
			}
			
			if(pq.isEmpty())
				return -1;
			Problem p = pq.poll();
			int cnt = p.getFailCnt();
			if(cnt == Integer.MAX_VALUE)
				return -1;
			failCnt += cnt;
			hIdea++;
			hImpl++;
		}
		return failCnt;
	}

}