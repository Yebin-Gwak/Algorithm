import java.io.*;
import java.util.*;

public class Main {

	static int[] jobs;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		jobs = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			jobs[i] = Integer.parseInt(st.nextToken());
		
		int ans = N;
		int min = 1;
		int max = N;
		
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
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max = 0;
		for(int job : jobs) {
			int t = ((pq.size() == K) ? pq.poll() : 0) + job;
			max = Math.max(max, t);
			if(max > X)
				return false;
			pq.add(t);
		}
		
		return true;
		
	}

}