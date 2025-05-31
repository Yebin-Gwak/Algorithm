import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		long[] times = new long[M];
		long minT = Long.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			long n = Long.parseLong(st.nextToken());
			times[i] = n;
			minT = Math.min(minT, n);
		}
		
		long min = 1;
		long max = minT * N;
		long ans = max;
		long pass = 0;
		while(min <= max) {
			long mid = (min + max) / 2;
			
			long cnt = M;
			for(int i = 0; i < M; i++)
				cnt += mid / times[i];
			
			if(cnt >= N) {
				ans = mid;
				pass = cnt;
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		for(int i = M - 1; i >= 0; i--) {
			if(ans % times[i] == 0 && pass-- == N) {
				System.out.println(i + 1);
				return;
			}
		}
		
	}

}