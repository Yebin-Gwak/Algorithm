import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static long minT;
	static long[] times;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if(N <= M) {
			System.out.println(N);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		times = new long[M];
		minT = Long.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			long n = Long.parseLong(st.nextToken());
			times[i] = n;
			minT = Math.min(minT, n);
		}
		
		long min = 1;
		long max = minT * N;
		long ans = max;
		while(min <= max) {
			long mid = (min + max) / 2 + (min + max) % 2;
			if(binarySearch(mid) >= N) {
				ans = mid;
				max = mid - 1;
			}else {
				min = mid + 1;
			}
		}
		
		long gap = (ans == 1 ? M : binarySearch(ans - 1));
		for(int i = 0; i < M; i++) {
			if(ans % times[i] == 0 && ++gap == N) {
				System.out.println(i + 1);
				return;
			}
		}
		
	}

	private static long binarySearch(long mid) {
		long cnt = M;
		for(int i = 0; i < M; i++)
			cnt += mid / times[i];
		
		return cnt;
	}
}