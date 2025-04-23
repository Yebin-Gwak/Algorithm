import java.util.*;
import java.io.*;

public class Main {
	
	static class Voice{
		int cnt;
		int end;
		
		public Voice(int cnt, int end) {
			this.cnt = cnt;
			this.end = end;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				arr[j][i] = Integer.parseInt(st.nextToken());
		}
		
		long power = 0;
		long curCnt = 0;
		long ans = 0;
		
		ArrayDeque<Voice> dq = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			power -= curCnt;
			if(!dq.isEmpty() && dq.peek().end == i)
				curCnt -= dq.poll().cnt;
			
			long goal = arr[i][1] - arr[i][0] - power;
			if(goal <= 0)
				continue;
			
			int cnt = (int) (goal / K + ((goal % K != 0) ? 1 : 0));
			power += K * cnt;
			curCnt += cnt;
			ans += cnt;
			dq.add(new Voice(cnt, i + K));
		}
		
		System.out.println(ans);
		
	}
}