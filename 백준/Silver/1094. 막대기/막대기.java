import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = Integer.parseInt(br.readLine());
		pq.add(64);
		
		int ans = 64;
		
		while(true) {
			if(ans == n) break;
			int m = pq.poll();
			int half = m / 2;
			if(ans - half >= n) {
				ans -= half;
				pq.add(half);
			}else {
				pq.add(half);
				pq.add(half);
			}
		}
		System.out.println(pq.size());
		
	}
}