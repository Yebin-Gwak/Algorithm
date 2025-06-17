import java.io.*;
import java.util.*;

public class Main {

	static long[] jobs;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		jobs = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			jobs[i] = Long.parseLong(st.nextToken());
		
		int ans = X;
		int min = 1;
		int max = X;
		
		while(min <= max) {
			int mid = (min + max) / 2;
			if(binarySearch(X, mid)) {
				ans = mid;
				max = mid - 1;
			}else
				min = mid + 1;
		}
		
		System.out.println(ans);
		
	}
	
	private static boolean binarySearch(int X, int K) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long max = 0;
		for(long job : jobs) {
			long t = ((pq.size() == K) ? pq.poll() : 0) + job;
			max = Math.max(max, t);
			pq.add(t);
		}
		
		return (max <= X) ? true : false;
		
	}

}